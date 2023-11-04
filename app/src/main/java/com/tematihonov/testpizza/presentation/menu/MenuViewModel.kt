package com.tematihonov.testpizza.presentation.menu

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematihonov.testpizza.data.local.ProductEntity
import com.tematihonov.testpizza.domain.models.responseProducts.Product
import com.tematihonov.testpizza.domain.usecase.LocalUseCase
import com.tematihonov.testpizza.domain.usecase.NetworkUseCase
import com.tematihonov.testpizza.utils.dtoToEntity
import com.tematihonov.testpizza.utils.entityToDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val networkUseCase: NetworkUseCase,
    private val localUseCase: LocalUseCase
): ViewModel() {

    val categories = listOf("Пицца", "Комбо", "Закуски", "Коктейли", "Кофе", "Напитки")
    var currentCategory by mutableStateOf("Пицца")
    var isLoadingProducts by mutableStateOf(false)

    var productsList by mutableStateOf(emptyList<Product>())
    var productsListLocal by mutableStateOf(emptyList<ProductEntity>())

    init {
        //loadNetworkProducts(currentCategory)
        loadLocalProducts(currentCategory)
    }


    fun loadNetworkProducts(currentCategory: String) {
        viewModelScope.launch {
            isLoadingProducts = true
            val result = networkUseCase.getProductsUseCase.invoke()
            if (result.isSuccessful) {
                val tempList = result.body()!!
                val newArr = ArrayList<Product>()
                tempList.forEach {
                    if (it.category == currentCategory) newArr.add(it)
                }
                productsList = newArr
                isLoadingProducts = false
                saveProductsFromNetworkToLocal(tempList)
                productsList.forEach {
                    Log.d("GGG", it.name)
                }
            }
        }
    }

    fun loadLocalProducts(currentCategory: String) {
        var result = ArrayList<Product>()
        viewModelScope.launch {
            localUseCase.getLocalProductsUseCase.invoke().collect {
                it.toMutableList().forEach { product ->
                    if (product.category == currentCategory) result.add(entityToDto(product))
                }
                productsList = result
            }
        }
    }

    private fun saveProductsFromNetworkToLocal(networkList: ArrayList<Product>) {
        viewModelScope.launch {
            networkList.forEach {
                localUseCase.saveProductToLocalUseCase.invoke(dtoToEntity(it))
            }
        }
    }

    fun setNewCategory(newCategory: String) {
        currentCategory = newCategory
        loadNetworkProducts(currentCategory)
    }
}