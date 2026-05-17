package com.zelada.foodspot.ui.details

import androidx.lifecycle.ViewModel
import com.zelada.foodspot.data.FoodRepository
import com.zelada.foodspot.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DetailState(
    val restaurant: Restaurant? = null
)


class DetailViewModel(
    private val repository: FoodRepository,
    private val restaurantId: Int
) : ViewModel() {

    private val _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState> = _state.asStateFlow()

    init {
        loadRestaurant()
    }

    private fun loadRestaurant() {
        val restaurant = repository.getRestaurants()
            .firstOrNull { it.id == restaurantId }

        _state.value = _state.value.copy(restaurant = restaurant)
    }
}
