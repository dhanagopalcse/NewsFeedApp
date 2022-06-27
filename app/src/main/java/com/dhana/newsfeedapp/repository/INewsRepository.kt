package com.dhana.newsfeedapp.repository;

import androidx.lifecycle.LiveData
import com.dhana.newsfeedapp.data.model.NewsArticle
import com.dhana.newsfeedapp.data.model.NewsResponse
import com.dhana.newsfeedapp.state.NetworkState

interface INewsRepository {
    suspend fun getNews(countryCode: String, pageNumber: Int): NetworkState<NewsResponse>

    suspend fun searchNews(searchQuery: String, pageNumber: Int): NetworkState<NewsResponse>

    suspend fun saveNews(news: NewsArticle): Long

    fun getSavedNews(): LiveData<List<NewsArticle>>

    suspend fun deleteNews(news: NewsArticle)

    suspend fun deleteAllNews()
}
