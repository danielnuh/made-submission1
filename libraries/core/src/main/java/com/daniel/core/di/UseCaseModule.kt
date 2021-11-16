package com.daniel.core.di

import com.daniel.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun provideListUseCase(listInteractor: ListInteractor): ListUseCase

    @Binds
    @Singleton
    abstract fun provideDetailUseCase(detailInteractor: DetailInteractor): DetailUseCase

    @Binds
    @Singleton
    abstract fun provideFavoriteUseCase(favoriteInteractor: FavoriteInteractor): FavoriteUseCase
}
