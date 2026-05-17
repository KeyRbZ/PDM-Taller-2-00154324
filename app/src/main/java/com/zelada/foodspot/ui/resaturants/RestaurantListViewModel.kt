package com.zelada.foodspot.ui.resaturants

import androidx.lifecycle.ViewModel
import com.zelada.foodspot.data.FoodRepository
import com.zelada.foodspot.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class RestaurantListState(
    val restaurantsByCategory: Map<String, List<Restaurant>> = emptyMap()
)

class RestaurantListViewModel(
    private val repository: FoodRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RestaurantListState())

    val state: StateFlow<RestaurantListState> = _state.asStateFlow()

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        val allRestaurants = repository.getRestaurants()
        val grouped = groupByCategory(allRestaurants)

        _state.value = _state.value.copy(restaurantsByCategory = grouped)
    }

    private fun groupByCategory(restaurants: List<Restaurant>): Map<String, List<Restaurant>> {
        val result = linkedMapOf<String, MutableList<Restaurant>>()

        restaurants.forEach { restaurant ->
            restaurant.categories.forEach { category ->
                result.getOrPut(category) { mutableListOf() }.add(restaurant)
            }
        }

        return result
    }
}
