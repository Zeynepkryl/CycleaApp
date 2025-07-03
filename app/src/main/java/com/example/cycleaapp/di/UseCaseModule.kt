package com.example.cycleaapp.di

import com.example.cycleaapp.domain.usecase.GetCurrentUser
import com.example.cycleaapp.domain.usecase.InitializeAppCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module for providing UseCase instances.
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideInitializeAppCache(useCase: InitializeAppCache): InitializeAppCache = useCase

    @Singleton
    @Provides
    fun provideGetCurrentUser(useCase: GetCurrentUser): GetCurrentUser = useCase
}
