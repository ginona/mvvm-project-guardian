package com.example.mvvm_project_guardian.data

import android.util.Log
import com.example.mvvm_project_guardian.data.model.NewsModel
import com.example.mvvm_project_guardian.data.model.NewsProvider
import com.example.mvvm_project_guardian.data.network.NewsService
import com.google.gson.Gson

class NewsRepository {
    private val api = NewsService()

    suspend fun getAllNews(): NewsModel {
        val response: NewsModel = api.getNews()
        NewsProvider.news = response
        Log.w("Response", Gson().toJson(response))
        return response
    }
}