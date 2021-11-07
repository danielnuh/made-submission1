package com.daniel.made1.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.daniel.data.BuildConfig
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.util.Resource
import com.daniel.made1.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var _binding: FragmentDetailBinding
    private val binding get() = _binding

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val movie = arguments?.getParcelable<MovieList>("TEST")

        if (movie != null) {
            detailViewModel.getDetailMovie(movie.id).observe(viewLifecycleOwner) { movie ->
                when (movie) {
                    is Resource.Success -> {
                        val movieDetailEntity = movie.data
                        with(binding) {
                            if (movieDetailEntity != null) {
                                title.text = movieDetailEntity.title
                                storyline.text = movieDetailEntity.overview
    //                            stars.text = movieDetailEntity.stars.toString()

                                Glide.with(requireActivity())
                                    .load(BuildConfig.IMAGE_URL+movieDetailEntity.posterPath)
                                    .into(image)
                            }
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

        /*detailViewModel.getDetailTvShow().observe(viewLifecycleOwner) { tvShow ->
            when (tvShow) {
                is Resource.Success -> {
                    val tvShowDetailEntity = tvShow.data
                    with(binding) {
                        if (tvShowDetailEntity != null) {
                            title.text = tvShowDetailEntity.originalName
                            storyline.text = tvShowDetailEntity.overview
//                            stars.text = movieDetailEntity.stars.toString()

                            Glide.with(requireActivity())
                                .load(tvShowDetailEntity.posterPath)
                                .into(image)
                        }
                    }
                }

                is Resource.Loading -> {
                    Log.d("RESPONES_API", "Loading")
                }

                is Resource.Error -> {
                    Log.d("RESPONES_API", "Error")
                }
            }
        }*/
    }


}