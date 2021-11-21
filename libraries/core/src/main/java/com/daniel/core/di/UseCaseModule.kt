package com.daniel.core.di

import com.daniel.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    @Singleton
    fun provideListUseCase(listInteractor: ListInteractor): ListUseCase

    @Binds
    @Singleton
    fun provideDetailUseCase(detailInteractor: DetailInteractor): DetailUseCase

    @Binds
    @Singleton
    fun provideFavoriteUseCase(favoriteInteractor: FavoriteInteractor): FavoriteUseCase
}
