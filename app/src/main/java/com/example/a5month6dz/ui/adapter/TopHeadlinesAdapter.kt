package com.example.a5month6dz.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a5month6dz.base.BaseDiffUtilItemCallback
import com.example.a5month6dz.databinding.ItemTopHeadlinesBinding
import com.example.a5month6dz.extensions.setImage
import com.example.a5month6dz.models.ArticlesItem

class TopHeadlinesAdapter : PagingDataAdapter<ArticlesItem, TopHeadlinesAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class ViewHolder(private val binding: ItemTopHeadlinesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ArticlesItem?) = with(binding) {
            title.text = item?.title
            author.text = item?.author
            publishedAt.text = item?.publishedAt
            desc.text = item?.description
            source.text = item?.source?.name
            time.text = item?.content
            img.setImage(item?.urlToImage!!)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopHeadlinesAdapter.ViewHolder {
        return ViewHolder(
            ItemTopHeadlinesBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TopHeadlinesAdapter.ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}