package com.daniel.data.source.local.room

import androidx.room.*
import com.daniel.data.source.local.entitiy.TvShowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowDao {
    @Query("SELECT * FROM tvshow")
    fun getAllTvShow(): Flow<List<TvShowEntity>>

    @Query("SELECT * FROM tvshow where isFavorite = 1")
    fun getFavoriteTvShow():Flow<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(tvshow: List<TvShowEntity>)

    @Update
    fun updateFavoriteTvShow(tvshow: TvShowEntity)
}