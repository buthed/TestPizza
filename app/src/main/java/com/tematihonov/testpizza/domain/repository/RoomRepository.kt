package com.tematihonov.testpizza.domain.repository

import com.tematihonov.testpizza.data.local.ProductEntity
import kotlinx.coroutines.flow.Flow

interface RoomRepository {

    suspend fun getLocalProducts(): Flow<List<ProductEntity>>

    suspend fun saveProductToLocal(product: ProductEntity)
}