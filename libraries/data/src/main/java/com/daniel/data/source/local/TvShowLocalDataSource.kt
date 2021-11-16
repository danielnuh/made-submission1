package com.daniel.data.source.local

import com.daniel.data.source.local.entitiy.TvShowEntity
import com.daniel.data.source.local.room.TvShowDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowLocalDataSource @Inject constructor(private val tvShowDao: TvShowDao) {

    fun getAll(): Flow<List<TvShowEntity>> = tvShowDao.getAll()

    fun getFavorite(): Flow<List<TvShowEntity>> = tvShowDao.getFavorite()

    fun getDetail(id:Int): Flow<TvShowEntity> = tvShowDao.getDetail(id)

    suspend fun insert(tvShowList: List<TvShowEntity>) = tvShowDao.insert(tvShowList)

    fun setFavorite(id:Int, isFavorite: Boolean) {
        tvShowDao.updateFavorite(id, isFavorite)
    }
}