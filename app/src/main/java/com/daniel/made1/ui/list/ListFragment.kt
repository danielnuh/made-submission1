package com.daniel.made1.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.domain.util.Resource
import com.daniel.made1.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val listViewModel:ListViewModel by viewModels()

    private val movieAdapter = MovieListAdapter()
    private val tvShowAdapter = TvShowListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        listViewModel.movie.observe(viewLifecycleOwner) { movie ->
            when (movie) {
                is Resource.Success -> {
                    movie.data?.let {
                        Log.d("RESPONES_API", "SUCCESS")
                        movieAdapter.submitList(it)
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

        listViewModel.tvShow.observe(viewLifecycleOwner) { movie ->
            when (movie) {
                is Resource.Success -> {
                    movie.data?.let {
                        Log.d("RESPONES_API", "SUCCESS")
                        tvShowAdapter.submitList(it)
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
}