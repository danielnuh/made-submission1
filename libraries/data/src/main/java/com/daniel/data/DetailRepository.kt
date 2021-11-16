package com.daniel.data

import com.daniel.data.source.local.MovieLocalDataSource
import com.daniel.data.source.local.TvShowLocalDataSource
import com.daniel.data.util.AppExecutors
import com.daniel.data.util.DataMapper
import com.daniel.domain.model.movie.MovieDetail
import com.daniel.domain.model.tvshow.TvShowDetail
import com.daniel.domain.repository.IDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailRepository @Inject constructor(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val appExecutors: AppExecutors
):IDetailRepository{
    override fun getMovieDetail(id: Int): Flow<MovieDetail> {
        return movieLocalDataSource.getDetail(id).map {
            DataMapper.mapEntityToDomainMovie(it)
        }
    }

    override fun getTvShowDetail(id: Int): Flow<TvShowDetail> {
        return tvShowLocalDataSource.getDetail(id).map {
            DataMapper.mapEntityToDomainTvShow(it)
        }
    }

    override fun isFavoriteMovie(id: Int): Flow<Boolean> {
        return movieLocalDataSource.getDetail(id).map {
            DataMapper.mapIsFavoriteMovie(it)
        }
    }

    override fun isFavoriteTvShow(id: Int): Flow<Boolean> {
        return tvShowLocalDataSource.getDetail(id).map {
            DataMapper.mapIsFavoriteTvShow(it)
        }
    }

    override fun setFavoriteMovie(id: Int, isFavorite: Boolean) {
        appExecutors.diskIO().execute {
            movieLocalDataSource.setFavorite(id, isFavorite)
        }
    }

    override fun setFavoriteTvShow(id: Int, isFavorite: Boolean) {
        appExecutors.diskIO().execute {
            tvShowLocalDataSource.setFavorite(id,isFavorite)
        }
    }
}