package com.daniel.domain.usecase

import com.daniel.domain.model.movie.MovieDetail
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.repository.IMovieRepository
import com.daniel.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface MovieUseCase {
    fun getMovie(): Flow<Resource<List<MovieList>>>
    fun getDetail(id:Int): Flow<Resource<MovieDetail>>
}

class MovieInteractor @Inject constructor(
    private val iMovieRepository: IMovieRepository
):MovieUseCase {
    override fun getMovie() = iMovieRepository.getMovie()

    override fun getDetail(id:Int) = iMovieRepository.getDetail(id)
}