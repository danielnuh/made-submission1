package com.daniel.favorite.di

import android.content.Context
import com.daniel.core.dependencies.FavoriteModuleDependencies
import com.daniel.favorite.FavoriteFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [FavoriteViewModelModule::class],
    dependencies = [FavoriteModuleDependencies::class]
)
interface FavoriteComponent {
    @Component.Factory
    interface Factory {
        fun create(
            dependencies: FavoriteModuleDependencies,
            @BindsInstance context: Context
        ): FavoriteComponent
    }

    fun inject(fragment: FavoriteFragment)
}