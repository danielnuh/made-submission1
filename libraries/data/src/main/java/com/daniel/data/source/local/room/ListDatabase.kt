package com.daniel.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daniel.data.source.local.entitiy.MovieEntity
import com.daniel.data.source.local.entitiy.TvShowEntity

@Database(
    entities = [
        MovieEntity::class,
        TvShowEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ListDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun tvShowDao(): TvShowDao
}