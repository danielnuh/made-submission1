package com.daniel.domain.usecase

import com.daniel.domain.model.movie.MovieDetail
import com.daniel.domain.model.tvshow.TvShowDetail
import com.daniel.domain.repository.IDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface DetailUseCase {
    fun getMovieDetail(id:Int): Flow<MovieDetail>
    fun getTvShowDetail(id:Int): Flow<TvShowDetail>
    fun isFavoriteMovie(id:Int): Flow<Boolean>
    fun isFavoriteTvShow(id:Int): Flow<Boolean>
    fun setFavoriteMovie(id:Int, isFavorite:Boolean)
    fun setFavoriteTvShow(id:Int, isFavorite:Boolean)
}

class DetailInteractor @Inject constructor(
    private val iDetailRepository: IDetailRepository
):DetailUseCase {
    override fun getMovieDetail(id:Int): Flow<MovieDetail> = iDetailRepository.getMovieDetail(id)

    override fun getTvShowDetail(id:Int): Flow<TvShowDetail> =  iDetailRepository.getTvShowDetail(id)

    override fun isFavoriteMovie(id: Int): Flow<Boolean> = iDetailRepository.isFavoriteMovie(id)

    override fun isFavoriteTvShow(id: Int): Flow<Boolean> = iDetailRepository.isFavoriteTvShow(id)

    override fun setFavoriteMovie(id: Int, isFavorite: Boolean) {
        iDetailRepository.setFavoriteMovie(id, isFavorite)
    }

    override fun setFavoriteTvShow(id: Int, isFavorite: Boolean) {
        iDetailRepository.setFavoriteTvShow(id, isFavorite)
    }

}