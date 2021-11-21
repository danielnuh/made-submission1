package com.daniel.made1.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.daniel.data.BuildConfig
import com.daniel.domain.model.movie.MovieList
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.made1.R
import com.daniel.made1.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val movieParcelable = arguments?.getParcelable<MovieList>(MOVIE)
        val tvShowParcelable = arguments?.getParcelable<TvShowList>(TV_SHOW)

        if (movieParcelable != null) {
            var isFavorite = false

            detailViewModel.getDetailMovie(movieParcelable.id)
                .observe(viewLifecycleOwner) { movie ->
                    with(binding) {
                        if (movie != null) {
                            title.text = movie.title
                            storyline.text = movie.overview
                            stars.text = (movie.voteAverage / 2).toString()

                            Glide.with(requireActivity())
                                .load(BuildConfig.IMAGE_URL + movie.posterPath)
                                .into(image)
                            isFavorite = movie.isFavorite

                            if (movie.isFavorite) {
                                binding.textBtnFavorite.text =
                                    requireActivity().getString(R.string.remove_favorite)
                            } else {
                                binding.textBtnFavorite.text =
                                    requireActivity().getString(R.string.add_favorite)
                            }
                        }
                    }
                }

            binding.btnFavorite.setOnClickListener {
                detailViewModel.setFavoriteMovie(
                    movieParcelable.id,
                    !isFavorite
                )
            }
        }

        if (tvShowParcelable != null) {
            var isFavorite = false

            detailViewModel.getDetailTvShow(tvShowParcelable.id)
                .observe(viewLifecycleOwner) { tvShow ->
                    with(binding) {
                        if (tvShow != null) {
                            title.text = tvShow.originalName
                            storyline.text = tvShow.overview
                            stars.text = (tvShow.voteAverage / 2).toString()

                            Glide.with(requireActivity())
                                .load(BuildConfig.IMAGE_URL + tvShow.posterPath)
                                .into(image)
                            isFavorite = tvShow.isFavorite
                            if (tvShow.isFavorite) {
                                binding.textBtnFavorite.text =
                                    requireActivity().getString(R.string.remove_favorite)
                            } else {
                                binding.textBtnFavorite.text =
                                    requireActivity().getString(R.string.add_favorite)
                            }
                        }
                    }
                }

            binding.btnFavorite.setOnClickListener {
                detailViewModel.setFavoriteTvShow(
                    tvShowParcelable.id,
                    !isFavorite
                )
            }

        }
    }

    companion object {
        const val MOVIE = "MOVIE_LIST"
        const val TV_SHOW = "TV_SHOW_LIST"
    }
}