package com.daniel.data.util

import com.daniel.data.network.response.movie.MovieDetailResponse
import com.daniel.data.network.response.movie.MovieListResponse
import com.daniel.data.network.response.tvshow.TvShowListResponse
import com.daniel.domain.model.movie.MovieDetail
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object DataMapper {

    fun mapResponseToDomainMovie(input: MovieListResponse) : Flow<List<MovieList>> {
        val dataArray = ArrayList<MovieList>()

        input.results.map {
            dataArray.add(MovieList(
                it.id,
                it.title,
                it.overview,
                it.releaseDate,
                it.posterPath
            ))
        }

        return flowOf(dataArray)
    }

    fun mapResponseToDomainTvShow(input: TvShowListResponse) : Flow<List<TvShowList>> {
        val dataArray = ArrayList<TvShowList>()

        input.results.map {
            dataArray.add(TvShowList(
                it.id,
                it.name,
                it.overview,
                it.firstAirDate,
                it.posterPath
            ))
        }

        return flowOf(dataArray)
    }

    fun mapResponseToDomainDetailMovie(input: MovieDetailResponse) : Flow<MovieDetail> {
        return flowOf(MovieDetail(
            input.id,
            input.title,
            input.overview,
            input.poster_path,
            input.release_date,
        ))
    }
}