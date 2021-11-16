package com.daniel.data.source.local.room

import androidx.room.*
import com.daniel.data.source.local.entitiy.TvShowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowDao {

    @Query("SELECT * FROM tvShow")
    fun getAll(): Flow<List<TvShowEntity>>

    @Query("SELECT * FROM tvShow where isFavorite = 1")
    fun getFavorite(): Flow<List<TvShowEntity>>

    @Query("SELECT * FROM tvShow where id = :id")
    fun getDetail(id:Int): Flow<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvShow: List<TvShowEntity>)

    @Query("UPDATE tvShow SET isFavorite = :isFavorite WHERE id = :id")
    fun updateFavorite(id:Int, isFavorite:Boolean)
}