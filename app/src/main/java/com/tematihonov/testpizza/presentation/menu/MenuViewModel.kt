package com.tematihonov.testpizza.presentation.menu

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(

): ViewModel() {

    val categories = listOf(
        "Пицца", "Комбо", "Закуски", "Коктейли", "Кофе", "Напитки", "Десерты"
    )
    var currentCategory by mutableStateOf("Пицца")

    fun setNewCategory(newCategory: String) {
        currentCategory = newCategory
    }
}