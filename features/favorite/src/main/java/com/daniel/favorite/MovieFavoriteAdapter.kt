package com.daniel.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daniel.data.BuildConfig
import com.daniel.domain.model.movie.MovieList
import com.daniel.made1.R
import com.daniel.made1.databinding.ItemPlayListBinding
import com.daniel.made1.ui.RateHelper
import com.daniel.made1.ui.detail.DetailFragment

class MovieFavoriteAdapter:RecyclerView.Adapter<MovieFavoriteAdapter.MovieViewHolder>() {

    private var list = ArrayList<MovieList>()

    fun setData(listMovie:List<MovieList>){
        this.list.clear()
        this.list.addAll(listMovie)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            val bundle = bundleOf(DetailFragment.MOVIE to list[position])
            holder.itemView.findNavController().navigate(R.id.action_favoriteFragment_to_detailFragment ,bundle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemPlayListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun getItemCount(): Int = list.size

    class MovieViewHolder(private val binding: ItemPlayListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movieList: MovieList){
            with(binding){
                title.text = movieList.title
                Glide.with(itemView.context)
                    .load(BuildConfig.IMAGE_URL+movieList.image)
                    .into(image)

                RateHelper(binding.rate).setRate(movieList.voteAverage/2)
            }
        }
    }
}