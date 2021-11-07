package com.daniel.made1.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daniel.domain.usecase.MovieUseCase
import com.daniel.domain.usecase.TvShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase,
    private val tvShowUseCase: TvShowUseCase):ViewModel(){

    fun getDetailMovie(id:Int) = movieUseCase.getDetail(id).asLiveData()

    fun getDetailTvShow(id:Int) = tvShowUseCase.getDetail(id).asLiveData()
}