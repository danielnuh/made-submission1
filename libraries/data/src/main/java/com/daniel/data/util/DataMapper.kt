    package com.daniel.data.util

import com.daniel.data.network.response.movie.MovieListResponse
import com.daniel.data.network.response.tvshow.TvShowListResponse
import com.daniel.data.source.local.entitiy.MovieEntity
import com.daniel.data.source.local.entitiy.TvShowEntity
import com.daniel.domain.model.movie.MovieDetail
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowDetail
import com.daniel.domain.model.tvshow.TvShowList

object DataMapper {


    fun mapResponseToEntityMovie(input: MovieListResponse): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()

        input.results.map {
            movieList.add(
                MovieEntity(
                    it.id,
                    it.title,
                    it.overview,
                    it.posterPath,
                    it.voteAverage,
                    false
                )
            )
        }

        return movieList
    }


    fun mapResponseToEntityTvShow(input: TvShowListResponse): List<TvShowEntity> {
        val tvShowList = ArrayList<TvShowEntity>()

        input.results.map {
            tvShowList.add(
                TvShowEntity(
                    it.id,
                    it.name,
                    it.overview,
                    it.posterPath,
                    it.voteAverage,
                    false
                )
            )
        }

        return tvShowList
    }

    fun mapResponseToDomainMovie(input: List<MovieEntity>): List<MovieList> {
        val dataArray = ArrayList<MovieList>()

        input.map {
            dataArray.add(
                MovieList(
                    it.id,
                    it.title,
                    it.overview,
                    it.rate,
                    it.image
                )
            )
        }

        return dataArray
    }

    fun mapResponseToDomainTvShow(input: List<TvShowEntity>): List<TvShowList> {
        val dataArray = ArrayList<TvShowList>()

        input.map {
            dataArray.add(
                TvShowList(
                    it.id,
                    it.title,
                    it.overview,
                    it.rate,
                    it.image
                )
            )
        }

        return dataArray
    }

    fun mapEntityToDomainMovie(input: MovieEntity): MovieDetail {
        return MovieDetail(
            input.id,
            input.title,
            input.overview,
            input.image,
            input.rate,
            input.isFavorite,
        )
    }

    fun mapEntityToDomainTvShow(input: TvShowEntity): TvShowDetail {
        return TvShowDetail(
            input.id,
            input.overview,
            input.image,
            input.title,
            input.rate,
            input.isFavorite,
        )
    }

    fun mapIsFavoriteMovie(input:MovieEntity):Boolean{
        return input.isFavorite
    }

    fun mapIsFavoriteTvShow(input:TvShowEntity):Boolean{
        return input.isFavorite
    }

}