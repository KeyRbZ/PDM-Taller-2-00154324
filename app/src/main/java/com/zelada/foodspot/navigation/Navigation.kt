package com.zelada.foodspot.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.zelada.foodspot.data.FoodRepositoryImpl
import com.zelada.foodspot.ui.cart.CartScreen
import com.zelada.foodspot.ui.details.RestaurantDetailScreen
import com.zelada.foodspot.ui.resaturants.RestaurantListScreen
import com.zelada.foodspot.ui.screens.SearchScreen
import kotlinx.serialization.Serializable

sealed class AppDestination : NavKey {

    @Serializable
    data object RestaurantList : AppDestination()

    @Serializable
    data class RestaurantDetail(val restaurantId: Int) : AppDestination()

    @Serializable
    data object Search : AppDestination()

    @Serializable
    data object Cart : AppDestination()
}

@Composable
fun FoodSpotNavigation() {
    val repository = remember { FoodRepositoryImpl() }

    val backStack = remember {
        mutableStateListOf<Any>(AppDestination.RestaurantList)
    }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is AppDestination.RestaurantList -> NavEntry(key) {
                    RestaurantListScreen(
                        repository = repository,
                        onRestaurantClick = { restaurantId ->
                            backStack.add(AppDestination.RestaurantDetail(restaurantId))
                        },
                        onSearchClick = {
                            backStack.add(AppDestination.Search)
                        },
                        onCartClick = {
                            backStack.add(AppDestination.Cart)
                        }
                    )
                }
                is AppDestination.RestaurantDetail -> NavEntry(key) {
                    RestaurantDetailScreen(
                        repository = repository,
                        restaurantId = key.restaurantId,
                        onBack = { backStack.removeLastOrNull() },
                        onCartClick = {
                            backStack.add(AppDestination.Cart)
                        }
                    )
                }
                is AppDestination.Search -> NavEntry(key) {
                    SearchScreen(
                        repository = repository,
                        onRestaurantClick = { restaurantId ->
                            backStack.add(AppDestination.RestaurantDetail(restaurantId))
                        },
                        onBack = { backStack.removeLastOrNull() }
                    )
                }
                is AppDestination.Cart -> NavEntry(key) {
                    CartScreen(
                        onBack = { backStack.removeLastOrNull() }
                    )
                }
                else -> NavEntry(key = Unit) {}
            }
        }
    )
}