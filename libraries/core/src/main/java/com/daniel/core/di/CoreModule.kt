package com.daniel.core.di

import androidx.lifecycle.ViewModelProvider
import com.daniel.core.ui.BaseViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [
    RepositoryModule::class,
    UseCaseModule::class
])

@InstallIn(SingletonComponent::class)
abstract class CoreModule {
    @Binds
    abstract fun bindViewModelFactory(factory: BaseViewModelFactory): ViewModelProvider.Factory
}