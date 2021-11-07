package com.daniel.data.source.local.entitiy

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "overview")
    var overview:String,

    @ColumnInfo(name = "release_date")
    var date:String,

    @ColumnInfo(name = "poster_path")
    var image:String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite:Boolean = false,
)