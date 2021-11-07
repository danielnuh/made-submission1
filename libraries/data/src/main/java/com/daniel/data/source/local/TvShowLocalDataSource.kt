package com.daniel.data.source.local

import com.daniel.data.source.local.entitiy.TvShowEntity
import com.daniel.data.source.local.room.TvShowDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowLocalDataSource @Inject constructor(private val tvShowDao: TvShowDao){

    fun getAllTvShow():Flow<List<TvShowEntity>> = tvShowDao.getAllTvShow()

    fun getFavoriteTvShow():Flow<List<TvShowEntity>> = tvShowDao.getFavoriteTvShow()

    suspend fun insertTvShow(tvShowList: List<TvShowEntity>)= tvShowDao.insertTvShow(tvShowList)

    fun setFavoriteTvShow(tvShow:TvShowEntity, isFavorite:Boolean){
        tvShow.isFavorite = isFavorite
        tvShowDao.updateFavoriteTvShow(tvShow)
    }
}