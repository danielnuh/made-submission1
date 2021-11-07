package com.daniel.core.di

import com.daniel.data.MovieRepository
import com.daniel.data.TvShowRepository
import com.daniel.data.di.NetworkModule
import com.daniel.domain.repository.IMovieRepository
import com.daniel.domain.repository.ITvShowRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [
    NetworkModule::class
])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun movieRepository(movieRepository: MovieRepository):IMovieRepository

    @Binds
    abstract fun tvShowRepository(tvShowRepository: TvShowRepository):ITvShowRepository
}