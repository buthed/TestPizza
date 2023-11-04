package com.tematihonov.testpizza.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tematihonov.testpizza.utils.RoomConstants.PRODUCTS_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    @Query("SELECT * FROM $PRODUCTS_TABLE")
    fun getLocalProducts(): Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveProductsToLocal(product: ProductEntity)
}