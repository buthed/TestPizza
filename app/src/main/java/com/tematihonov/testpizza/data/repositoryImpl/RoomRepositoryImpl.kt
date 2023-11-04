package com.tematihonov.testpizza.data.repositoryImpl

import com.tematihonov.testpizza.data.local.ProductEntity
import com.tematihonov.testpizza.data.local.ProductsDao
import com.tematihonov.testpizza.domain.repository.RoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomRepositoryImpl @Inject constructor(
    private val productsDao: ProductsDao
): RoomRepository {

    override suspend fun getLocalProducts(): Flow<List<ProductEntity>> {
        return productsDao.getLocalProducts()
    }

    override suspend fun saveProductToLocal(product: ProductEntity) {
        productsDao.saveProductsToLocal(product)
    }
}