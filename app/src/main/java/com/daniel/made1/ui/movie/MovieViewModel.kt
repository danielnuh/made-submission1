package com.daniel.made1.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daniel.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getMovie().asLiveData()
}