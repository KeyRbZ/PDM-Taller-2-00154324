package com.zelada.foodspot.data

import com.zelada.foodspot.model.Dish
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object CartRepository {


    private val _items = MutableStateFlow<List<Dish>>(emptyList())
    val items: StateFlow<List<Dish>> = _items.asStateFlow()

    fun addItem(dish: Dish) {
        _items.value = _items.value + dish
    }

    fun removeItem(dish: Dish) {
        _items.value = _items.value - dish
    }

    fun count(): Int = _items.value.size
}