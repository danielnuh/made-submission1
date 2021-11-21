package com.daniel.favorite.di

import androidx.lifecycle.ViewModel
import com.daniel.core.di.ViewModelKey
import com.daniel.favorite.FavoriteViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(FragmentComponent::class)
interface FavoriteViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    fun bindFavoriteVM(viewModel: FavoriteViewModel): ViewModel
}