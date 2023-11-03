package com.tematihonov.testpizza.data.repositoryImpl

import com.tematihonov.testpizza.data.network.ApiService
import com.tematihonov.testpizza.domain.models.responseProducts.Product
import com.tematihonov.testpizza.domain.repository.NetworkRepository
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): NetworkRepository {

    override suspend fun getProducts(): Response<ArrayList<Product>> {
        return apiService.getProducts()
    }
}