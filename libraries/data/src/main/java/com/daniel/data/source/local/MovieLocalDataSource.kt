package com.daniel.data.source.local

import com.daniel.data.source.local.entitiy.MovieEntity
import com.daniel.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getAll(): Flow<List<MovieEntity>> = movieDao.getAll()

    fun getFavorite(): Flow<List<MovieEntity>> = movieDao.getFavorite()

    fun getDetail(id:Int): Flow<MovieEntity> = movieDao.getDetail(id)

    suspend fun insert(movieList: List<MovieEntity>) = movieDao.insert(movieList)

    fun setFavorite(id:Int, isFavorite: Boolean) {
        movieDao.updateFavorite(id, isFavorite)
    }
}