package com.daniel.data.source.local.entitiy

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvShow")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "overview")
    var overview:String,

    @ColumnInfo(name = "image")
    var image:String,

    @ColumnInfo(name = "rate")
    var rate:Float,

    @ColumnInfo(name = "isFavorite")
    var isFavorite:Boolean,
)