package com.daniel.made1.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daniel.data.BuildConfig
import com.daniel.domain.model.tvshow.TvShowList
import com.daniel.made1.databinding.ItemPlayListBinding

class TvShowListAdapter:RecyclerView.Adapter<TvShowListAdapter.TvShowViewHolder>() {

    private var list = ArrayList<TvShowList>()

    fun setData(listTvShow:List<TvShowList>){
        this.list.clear()
        this.list.addAll(listTvShow)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(ItemPlayListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun getItemCount(): Int = list.size

    class TvShowViewHolder(private val binding: ItemPlayListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(tvShowList: TvShowList){
            with(binding){
                title.text = tvShowList.name
                Glide.with(itemView.context)
                    .load(BuildConfig.IMAGE_URL+tvShowList.posterPath)
                    .into(image)
            }
        }
    }
}