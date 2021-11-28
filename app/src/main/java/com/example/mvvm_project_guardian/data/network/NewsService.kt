package com.example.mvvm_project_guardian.data.network

import android.util.Log
import com.example.mvvm_project_guardian.core.RetrofitHelper
import com.example.mvvm_project_guardian.data.model.NewsModel
import com.example.mvvm_project_guardian.data.model.Result
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewsService {
    private val retrofit = RetrofitHelper.getRetrofit()
    val API_KEY = "83ee18cb-9e54-481f-929d-57d4b0cc87c1"
    val API_REQUEST_TYPE = "article"
    val API_BLOCK_TYPE = "body"

    suspend fun getNews(): NewsModel{
        return withContext(Dispatchers.IO){
            val response: Response<NewsModel> = retrofit.create(NewsApiClient::class.java).getAllNews(API_KEY, API_REQUEST_TYPE, API_BLOCK_TYPE)
            (response.body() ?: response.errorBody()) as NewsModel
        }

    }
}