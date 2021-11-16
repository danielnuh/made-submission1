package com.daniel.domain.model.tvshow

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowDetail(
    val id:Int,
    val overview:String,
    val posterPath:String,
    val originalName:String,
    val voteAverage:Float,
    val isFavorite:Boolean,
):Parcelable