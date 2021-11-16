package com.daniel.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daniel.domain.usecase.FavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
     favoriteUseCase: FavoriteUseCase
):ViewModel() {
     val movie = favoriteUseCase.getMovie().asLiveData()
     val tvShow = favoriteUseCase.getTvShow().asLiveData()
}