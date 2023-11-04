package com.tematihonov.testpizza.domain.usecase.network

import com.tematihonov.testpizza.domain.models.responseProducts.Product
import com.tematihonov.testpizza.domain.repository.NetworkRepository
import retrofit2.Response
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val networkRepository: NetworkRepository
) {

    suspend fun invoke(): Response<ArrayList<Product>> {
        return networkRepository.getProducts()
    }
}