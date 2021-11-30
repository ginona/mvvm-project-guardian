package com.example.mvvm_project_guardian.domain

import com.example.mvvm_project_guardian.data.NewsRepository
import com.example.mvvm_project_guardian.data.model.NewsModel

class GetNews {

    private val repository = NewsRepository()

    suspend operator fun invoke(pageNumber: Int): NewsModel {
        return repository.getAllNews(pageNumber)
    }

}