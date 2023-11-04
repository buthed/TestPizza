package com.tematihonov.testpizza.di

import com.tematihonov.testpizza.data.repositoryImpl.NetworkRepositoryImpl
import com.tematihonov.testpizza.data.repositoryImpl.RoomRepositoryImpl
import com.tematihonov.testpizza.domain.repository.NetworkRepository
import com.tematihonov.testpizza.domain.repository.RoomRepository
import com.tematihonov.testpizza.domain.usecase.LocalUseCase
import com.tematihonov.testpizza.domain.usecase.NetworkUseCase
import com.tematihonov.testpizza.domain.usecase.local.GetLocalProductsUseCase
import com.tematihonov.testpizza.domain.usecase.local.SaveProductToLocalUseCase
import com.tematihonov.testpizza.domain.usecase.network.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideNetworkRepositoryImpl(repository: NetworkRepositoryImpl): NetworkRepository {
        return repository
    }

    @Singleton
    @Provides
    fun provideNetworkUseCases(networkRepository: NetworkRepository): NetworkUseCase {
        return NetworkUseCase(
            getProductsUseCase = GetProductsUseCase(networkRepository),
        )
    }

    @Singleton
    @Provides
    fun provideRoomRepositoryImpl(repository: RoomRepositoryImpl): RoomRepository {
        return repository
    }

    @Singleton
    @Provides
    fun provideLocalUseCases(roomRepositoryImpl: RoomRepositoryImpl): LocalUseCase {
        return LocalUseCase(
            getLocalProductsUseCase = GetLocalProductsUseCase(roomRepositoryImpl),
            saveProductToLocalUseCase = SaveProductToLocalUseCase(roomRepositoryImpl)
        )
    }
}