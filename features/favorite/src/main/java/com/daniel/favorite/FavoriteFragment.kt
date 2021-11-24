package com.daniel.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.core.dependencies.FavoriteModuleDependencies
import com.daniel.core.ui.BaseViewModelFactory
import com.daniel.favorite.databinding.FragmentFavoriteBinding
import com.daniel.favorite.di.DaggerFavoriteComponent
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    @Inject
    lateinit var factory: BaseViewModelFactory

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private val movieAdapter = MovieFavoriteAdapter()
    private val tvShowAdapter = TvShowFavoriteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        DaggerFavoriteComponent.factory()
            .create(
                EntryPointAccessors.fromApplication(
                    requireContext(),
                    FavoriteModuleDependencies::class.java
                ), requireContext()
            ).inject(this)

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteViewModel.movie.observe(viewLifecycleOwner) { movie ->
            movieAdapter.submitList(movie)
        }

        favoriteViewModel.tvShow.observe(viewLifecycleOwner) { tvShow ->
            tvShowAdapter.submitList(tvShow)
        }
    }

    override fun onResume() {
        super.onResume()
        setRecycler()
    }

    override fun onDestroyView() {
        with(binding){
            rvMovie.adapter = null
            rvTvShow.adapter = null
        }
        super.onDestroyView()
        _binding = null

    }

    private fun setRecycler() {

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        with(binding.rvTvShow) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }
}