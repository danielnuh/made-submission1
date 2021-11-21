package com.daniel.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daniel.domain.usecase.FavoriteUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
     favoriteUseCase: FavoriteUseCase
):ViewModel() {
     val movie = favoriteUseCase.getMovie().asLiveData()
     val tvShow = favoriteUseCase.getTvShow().asLiveData()
}