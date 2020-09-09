package com.interestingarticles.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.interestingarticles.databinding.ArticleRecyclerItemBinding
import com.interestingarticles.models.Article

class ArticleAdapter(private val onItemClickListener: OnItemClickListener) :
    ListAdapter<Article, ArticleAdapter.ArticleViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            ArticleRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article, onItemClickListener)
    }

    class ArticleViewHolder(private val binding: ArticleRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Article, onItemClickListener: OnItemClickListener) {
            binding.apply {
                article = item
                itemView.setOnClickListener { onItemClickListener.onItemClick(item) }
                executePendingBindings()
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    interface OnItemClickListener {
        fun onItemClick(article: Article)
    }

}