package com.daniel.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daniel.data.BuildConfig
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.made1.R
import com.daniel.made1.databinding.ItemPlayListBinding
import com.daniel.made1.ui.RateHelper
import com.daniel.made1.ui.detail.DetailFragment

class TvShowFavoriteAdapter: ListAdapter<TvShowList,TvShowFavoriteAdapter.ViewHolder>(DataDifferntiator) {

    class ViewHolder(private val binding: ItemPlayListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(tvShowList: TvShowList){
            with(binding){
                title.text = tvShowList.name

                RateHelper(binding.rate).setRate(tvShowList.voteAverage/2)

                Glide.with(itemView.context)
                    .load(BuildConfig.IMAGE_URL+tvShowList.posterPath)
                    .into(image)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = getItem(position)
        if (list != null) {
            holder.bind(list)
            holder.itemView.setOnClickListener {
                val bundle = bundleOf(DetailFragment.TV_SHOW to list)
                holder.itemView.findNavController().navigate(R.id.action_favoriteFragment_to_detailFragment,bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPlayListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    object DataDifferntiator : DiffUtil.ItemCallback<TvShowList>() {

        override fun areItemsTheSame(oldItem: TvShowList, newItem: TvShowList): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowList, newItem: TvShowList): Boolean {
            return oldItem == newItem
        }
    }
}