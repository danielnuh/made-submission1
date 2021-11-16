package com.daniel.made1.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daniel.domain.usecase.DetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailUseCase: DetailUseCase
):ViewModel(){

    fun getDetailMovie(id:Int) = detailUseCase.getMovieDetail(id).asLiveData()

    fun getDetailTvShow(id:Int) = detailUseCase.getTvShowDetail(id).asLiveData()

    fun getFavoriteStatusMovie(id:Int) = detailUseCase.isFavoriteMovie(id).asLiveData()

    fun getFavoriteStatusTvShow(id:Int) = detailUseCase.isFavoriteTvShow(id).asLiveData()

    fun setFavoriteMovie(id:Int, isFavorite:Boolean){
        detailUseCase.setFavoriteMovie(id, isFavorite)
    }

    fun setFavoriteTvShow(id:Int, isFavorite:Boolean){
        detailUseCase.setFavoriteTvShow(id, isFavorite)
    }
}