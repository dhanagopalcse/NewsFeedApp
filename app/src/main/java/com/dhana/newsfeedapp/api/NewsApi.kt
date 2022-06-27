package com.dhana.newsfeedapp.network.api

import com.dhana.newsfeedapp.utils.Constants.Companion.API_KEY
import com.dhana.newsfeedapp.utils.Constants.Companion.CountryCode
import com.dhana.newsfeedapp.utils.Constants.Companion.QUERY_PER_PAGE
import com.dhana.newsfeedapp.data.model.NewsResponse
import com.dhana.newsfeedapp.utils.Constants.Companion.Category
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country")
        countryCode: String = CountryCode,
        @Query("page")
        pageNumber: Int = 1,
        @Query("category")
        categoryCode:String=Category,
        @Query("pageSize")
        pageSize: Int = QUERY_PER_PAGE,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("pageSize")
        pageSize: Int = QUERY_PER_PAGE,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}