package com.example.mvvm_project_guardian.domain

import com.example.mvvm_project_guardian.data.NewsRepository
import com.example.mvvm_project_guardian.data.model.NewsModel

class GetNews {

    private val repository = NewsRepository()

    //De esta forma accedemos directamente a la función sin tener que instanciar GetNews y luego con un punto
    //llamar a la función
    suspend operator fun invoke(pageNumber: Int): NewsModel {
        return repository.getAllNews(pageNumber)
    }

}