package com.daniel.data.di

import android.content.Context
import androidx.room.Room
import com.daniel.data.source.local.room.ListDatabase
import com.daniel.data.source.local.room.MovieDao
import com.daniel.data.source.local.room.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ListDatabase = Room.databaseBuilder(
        context,
        ListDatabase::class.java, "List.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieDao(database: ListDatabase): MovieDao = database.movieDao()

    @Provides
    fun provideTvShowDao(database: ListDatabase): TvShowDao = database.tvShowDao()
}