package com.tematihonov.testpizza.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class ProductsDataBase: RoomDatabase() {

    abstract fun appDBDao(): ProductsDao
}