package com.daniel.domain.repository

import com.daniel.domain.model.movie.MovieDetail
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getMovie(): Flow<Resource<List<MovieList>>>

    fun getDetail(id:Int): Flow<Resource<MovieDetail>>
}