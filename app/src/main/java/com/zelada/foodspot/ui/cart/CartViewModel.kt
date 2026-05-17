package com.zelada.foodspot.ui.cart


import androidx.lifecycle.ViewModel
import com.zelada.foodspot.data.CartRepository
import com.zelada.foodspot.model.Dish
import kotlinx.coroutines.flow.StateFlow

class CartViewModel : ViewModel() {

    val items: StateFlow<List<Dish>> = CartRepository.items

    fun removeItem(dish: Dish) {
        CartRepository.removeItem(dish)
    }
}