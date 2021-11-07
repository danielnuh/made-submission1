package com.daniel.domain.model.tvshow

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowList(
    val id:Int,
    val name:String,
    val overview:String,
    val firstAirDate:String,
    val posterPath:String,
):Parcelable
