package com.dhana.newsfeedapp.data.model


data class NewsResponse(
    val articles: MutableList<NewsArticle>,
    val status: String,
    val totalResults: Int
)