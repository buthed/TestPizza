package com.tematihonov.testpizza.domain.usecase

import com.tematihonov.testpizza.domain.usecase.local.GetLocalProductsUseCase
import com.tematihonov.testpizza.domain.usecase.local.SaveProductToLocalUseCase

data class LocalUseCase(
    val getLocalProductsUseCase: GetLocalProductsUseCase,
    val saveProductToLocalUseCase: SaveProductToLocalUseCase
)