package com.example.mvvm_project_guardian.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_project_guardian.data.model.NewsModel
import com.example.mvvm_project_guardian.domain.GetNews
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    val newsModel = MutableLiveData<NewsModel>()
    var getNewsUseCase = GetNews()

    fun onCreate() {
        viewModelScope.launch {
            val result = getNewsUseCase()
            newsModel.postValue(result)

        }
    }
}