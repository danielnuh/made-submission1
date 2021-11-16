package com.daniel.data.source.local.room

import androidx.room.*
import com.daniel.data.source.local.entitiy.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAll(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie where isFavorite = 1")
    fun getFavorite(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie where id = :id")
    fun getDetail(id:Int): Flow<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: List<MovieEntity>)

    @Query("UPDATE movie SET isFavorite = :isFavorite WHERE id = :id")
    fun updateFavorite(id:Int, isFavorite:Boolean)
}