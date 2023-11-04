package com.tematihonov.testpizza.domain.usecase.local

import com.tematihonov.testpizza.data.local.ProductEntity
import com.tematihonov.testpizza.domain.repository.RoomRepository
import javax.inject.Inject

class SaveProductToLocalUseCase @Inject constructor(
    private val roomRepository: RoomRepository
) {
    suspend fun invoke(product: ProductEntity) {
        return roomRepository.saveProductToLocal(product)
    }
}