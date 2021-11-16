package com.daniel.core.di

import com.daniel.data.DetailRepository
import com.daniel.data.FavoriteRepository
import com.daniel.data.ListRepository
import com.daniel.data.di.DatabaseModule
import com.daniel.data.di.NetworkModule
import com.daniel.domain.repository.IDetailRepository
import com.daniel.domain.repository.IFavoriteRepository
import com.daniel.domain.repository.IListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [
    NetworkModule::class,
    DatabaseModule::class
])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun listRepository(listRepository: ListRepository):IListRepository

    @Binds
    abstract fun detailRepository(detailRepository: DetailRepository):IDetailRepository

    @Binds
    abstract fun favoriteRepository(favoriteRepository: FavoriteRepository):IFavoriteRepository
}