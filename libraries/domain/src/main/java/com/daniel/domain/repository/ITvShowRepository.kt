package com.daniel.domain.repository

import com.daniel.domain.model.tvshow.TvShowDetail
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ITvShowRepository {
    fun getTvShow(): Flow<Resource<List<TvShowList>>>

    fun getDetailTvShow(id:Int):Flow<Resource<TvShowDetail>>
}