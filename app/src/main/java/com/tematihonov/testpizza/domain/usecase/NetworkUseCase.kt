package com.tematihonov.testpizza.domain.usecase

import com.tematihonov.testpizza.domain.usecase.network.GetProductsUseCase

data class NetworkUseCase(
    val getProductsUseCase: GetProductsUseCase
)