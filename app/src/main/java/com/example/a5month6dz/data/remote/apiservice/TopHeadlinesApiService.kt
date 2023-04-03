package com.example.a5month6dz.data.remote.apiservice

import com.example.a5month6dz.models.ArticlesItem
import com.example.a5month6dz.models.NewsClass
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService {

    @GET("v2/everything?apiKey=8f4cb53689c246428ee62342f5ae7cf0")
    suspend fun fetchTopHeadlines(
        @Query("page") page: String,
        @Query("q") query: Int
    ): NewsClass<ArticlesItem>
}
