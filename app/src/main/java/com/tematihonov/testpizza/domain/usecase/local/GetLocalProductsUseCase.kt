package com.tematihonov.testpizza.domain.usecase.local

import com.tematihonov.testpizza.data.local.ProductEntity
import com.tematihonov.testpizza.domain.repository.RoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocalProductsUseCase @Inject constructor(
    private val roomRepository: RoomRepository
) {
    suspend fun invoke(): Flow<List<ProductEntity>> {
        return roomRepository.getLocalProducts()
    }

}