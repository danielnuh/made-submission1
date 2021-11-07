package com.daniel.made1.di

import com.daniel.domain.usecase.MovieInteractor
import com.daniel.domain.usecase.MovieUseCase
import com.daniel.domain.usecase.TvShowInteractor
import com.daniel.domain.usecase.TvShowUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor): MovieUseCase

    @Binds
    @Singleton
    abstract fun provideTvShowUseCase(tvShowInteractor: TvShowInteractor): TvShowUseCase

}
