package com.daniel.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.favorite.databinding.FragmentFavoriteBinding
import com.daniel.made1.ui.list.MovieListAdapter
import com.daniel.made1.ui.list.TvShowListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private lateinit var _binding: FragmentFavoriteBinding
    private val binding get() = _binding

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private val movieAdapter = MovieListAdapter()
    private val tvShowAdapter = TvShowListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding  = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecycler()

        favoriteViewModel.movie.observe(viewLifecycleOwner) { movie ->
            if (movie.isNotEmpty()){
                movieAdapter.setData(movie)
                movieAdapter.notifyDataSetChanged()
            }
        }

        favoriteViewModel.tvShow.observe(viewLifecycleOwner) { tvShow ->
            if (tvShow.isNotEmpty()){
                tvShowAdapter.setData(tvShow)
                tvShowAdapter.notifyDataSetChanged()
            }
        }
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