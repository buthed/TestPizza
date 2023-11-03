package com.tematihonov.testpizza.data.network

import com.tematihonov.testpizza.domain.models.responseProducts.Product
import com.tematihonov.testpizza.utils.RetrofitConstants.PRODUCTS
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(PRODUCTS)
    suspend fun getProducts(): Response<ArrayList<Product>>
}