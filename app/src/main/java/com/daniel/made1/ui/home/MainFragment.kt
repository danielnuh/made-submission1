package com.daniel.made1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.domain.util.Resource
import com.daniel.made1.databinding.FragmentMainBinding
import com.daniel.made1.ui.movie.MovieViewModel
import com.daniel.made1.ui.movie.MovieListAdapter
import com.daniel.made1.ui.tvshow.TvShowListAdapter
import com.daniel.made1.ui.tvshow.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var _binding: FragmentMainBinding
    private val binding get() = _binding

    private val movieViewModel: MovieViewModel by viewModels()
    private val tvShowViewModel: TvShowViewModel by viewModels()

    private val movieAdapter = MovieListAdapter()
    private val tvShowAdapter = TvShowListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecycler()

        movieViewModel.movie.observe(viewLifecycleOwner) { movie ->
            when (movie) {
                is Resource.Success -> {
                    movie.data?.let {
                        movieAdapter.setData(it)
                        movieAdapter.notifyDataSetChanged()
                    }
                }

                is Resource.Loading -> {
                    Log.d("RESPONES_API", "Loading")
                }

                is Resource.Error -> {
                    Log.d("RESPONES_API", "Error")
                }
            }
        }

        tvShowViewModel.tvShow.observe(viewLifecycleOwner) { movie ->
            when (movie) {
                is Resource.Success -> {
                    movie.data?.let {
                        tvShowAdapter.setData(it)
                        tvShowAdapter.notifyDataSetChanged()
                    }
                }

                is Resource.Loading -> {
                    Log.d("RESPONES_API", "Loading")
                }

                is Resource.Error -> {
                    Log.d("RESPONES_API", "Error")
                }
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

        with(binding.rvFavorite) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }
}