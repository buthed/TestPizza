package com.tematihonov.testpizza.di

import android.content.Context
import androidx.room.Room
import com.tematihonov.testpizza.data.local.ProductsDataBase
import com.tematihonov.testpizza.utils.RoomConstants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideSpaceFruitsDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ProductsDataBase::class.java,
            DB_NAME,
        ).build()

    @Singleton
    @Provides
    fun provideProductsDao(productsDataBase: ProductsDataBase) =
        productsDataBase.appDBDao()
}