package com.zelada.foodspot.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.zelada.foodspot.data.FoodRepository
import com.zelada.foodspot.model.Restaurant
import com.zelada.foodspot.ui.resaturants.PrimaryPurple


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    repository: FoodRepository,
    onRestaurantClick: (Int) -> Unit,
    onBack: () -> Unit
) {
    val viewModel = remember { SearchViewModel(repository) }
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buscar", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = state.query,
                onValueChange = { viewModel.onQueryChange(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        "Busca un restaurante o platillo",
                        color = Color.Gray
                    )
                },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null, tint = PrimaryPurple)
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PrimaryPurple,
                    unfocusedBorderColor = Color(0xFFDDDDDD)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            when {
                state.results.isNotEmpty() -> {
                    Text(
                        text = "${state.results.size} resultado(s) encontrado(s)",
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        items(state.results) { restaurant ->
                            SearchResultCard(
                                restaurant = restaurant,
                                onClick = { onRestaurantClick(restaurant.id) }
                            )
                        }
                    }
                }

                state.hasSearched && state.results.isEmpty() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                modifier = Modifier.size(64.dp),
                                tint = Color(0xFFCCCCCC)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "No se encontraron resultados",
                                fontSize = 16.sp,
                                color = Color(0xFF999999)
                            )
                        }
                    }
                }

                else -> {}
            }
        }
    }
}

@Composable
fun SearchResultCard(
    restaurant: Restaurant,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = restaurant.imageUrl,
                contentDescription = restaurant.name,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = restaurant.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF1A1A1A)
                )
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = restaurant.description,
                    fontSize = 12.sp,
                    color = Color(0xFF777777),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    restaurant.categories.take(2).forEach { category ->
                        CategoryChip(category)
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryChip(text: String) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = PrimaryPurple.copy(alpha = 0.15f),
    ) {
        Text(
            text = text,
            fontSize = 11.sp,
            color = PrimaryPurple,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        )
    }
}
