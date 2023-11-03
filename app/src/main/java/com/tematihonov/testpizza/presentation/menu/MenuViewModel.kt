package com.tematihonov.testpizza.presentation.menu

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematihonov.testpizza.domain.models.responseProducts.Product
import com.tematihonov.testpizza.domain.usecase.NetworkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val networkUseCase: NetworkUseCase
): ViewModel() {

    val categories = listOf(
        "Пицца", "Комбо", "Закуски", "Коктейли", "Кофе", "Напитки", "Десерты"
    )
    var currentCategory by mutableStateOf("Пицца")
    var isLoadingProducts by mutableStateOf(true)

    var productsList by mutableStateOf(emptyList<Product>())

    init {
        loadProducts(currentCategory)
    }


    fun loadProducts(currentCategory: String) {
        viewModelScope.launch {
            val result = networkUseCase.getProductsUseCase.invoke()
            isLoadingProducts = true
            if (result.isSuccessful) {
                val tempList = result.body()!!
                val newArr = ArrayList<Product>()
                tempList.forEach {
                    if (it.category == currentCategory) newArr.add(it)
                }
                productsList = newArr
                isLoadingProducts = false
                productsList.forEach {
                    Log.d("GGG", it.name)
                }
            }
        }
    }


    fun setNewCategory(newCategory: String) {
        currentCategory = newCategory
        loadProducts(currentCategory)
    }
}