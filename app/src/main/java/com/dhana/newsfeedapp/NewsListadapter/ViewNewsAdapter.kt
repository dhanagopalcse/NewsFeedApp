package com.dhana.newsfeedapp.NewsListadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dhana.newsfeedapp.R
import com.dhana.newsfeedapp.databinding.ItemNewsBinding
import com.dhana.newsfeedapp.data.model.NewsArticle

class ViewNewsAdapter : RecyclerView.Adapter<ViewNewsAdapter.NewsAdapterViewHolder>() {

    inner class NewsAdapterViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<NewsArticle>() {
        override fun areItemsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val binding =
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return NewsAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((NewsArticle) -> Unit)? = null

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        val article = differ.currentList[position]
        with(holder) {
            Glide.with(itemView.context)
                .load(article.urlToImage)
                .placeholder(R.drawable.placeholder_image)
                .into(binding.ivArticleImage)
            binding.tvDescription.text = article.description
            binding.tvPublishedAt.text = article.publishedAt
            binding.tvTitle.text = article.title
        }

        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            }
        }
    }

    fun setOnItemClickListener(listener: (NewsArticle) -> Unit) {
        onItemClickListener = listener
    }
}