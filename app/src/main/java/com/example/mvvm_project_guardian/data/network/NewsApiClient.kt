package com.example.mvvm_project_guardian.data.network

import com.example.mvvm_project_guardian.data.model.NewsModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiClient {
    @GET("search")
    suspend fun getAllNews(
        @Query("api-key") apiKey: String?,
        @Query("type") type: String?,
        @Query("show-blocks") showBlocks: String?
    ): Response<NewsModel>
}