package com.zelada.foodspot.ui.search

import androidx.lifecycle.ViewModel
import com.zelada.foodspot.data.FoodRepository
import com.zelada.foodspot.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SearchState(
    val query: String = "",
    val results: List<Restaurant> = emptyList(),
    val hasSearched: Boolean = false
)

class SearchViewModel(
    private val repository: FoodRepository
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    fun onQueryChange(newQuery: String) {
        _state.value = _state.value.copy(query = newQuery)

        if (newQuery.isBlank()) {
            _state.value = _state.value.copy(
                results = emptyList(),
                hasSearched = false
            )
        } else {
            val results = repository.searchRestaurants(newQuery)
            _state.value = _state.value.copy(
                results = results,
                hasSearched = true
            )
        }
    }
}
