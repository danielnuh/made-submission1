package com.daniel.data.source.local

import com.daniel.data.source.local.entitiy.MovieEntity
import com.daniel.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao){

    fun getAllMovie():Flow<List<MovieEntity>> = movieDao.getAllMovie()

    fun getFavoriteMovie():Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertMovie(movieEntityList: List<MovieEntity>)= movieDao.insertMovie(movieEntityList)

    fun setFavoriteMovie(movie:MovieEntity, isFavorite:Boolean){
        movie.isFavorite = isFavorite
        movieDao.updateFavoriteMovie(movie)
    }
}