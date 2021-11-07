package com.daniel.data.source.local.entitiy

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshow")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "description")
    var description:String,

    @ColumnInfo(name = "date")
    var date:String,

    @ColumnInfo(name = "image")
    var image:String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite:Boolean = false,
)
