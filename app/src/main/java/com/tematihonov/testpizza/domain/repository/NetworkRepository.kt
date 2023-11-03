package com.tematihonov.testpizza.domain.repository

import com.tematihonov.testpizza.domain.models.responseProducts.Product
import retrofit2.Response

interface NetworkRepository {

    suspend fun getProducts(): Response<ArrayList<Product>>

}