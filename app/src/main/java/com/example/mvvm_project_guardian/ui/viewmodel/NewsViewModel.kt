package com.example.mvvm_project_guardian.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.mvvm_project_guardian.data.model.NewsModel
import com.example.mvvm_project_guardian.domain.GetNews
import com.example.mvvm_project_guardian.paging.ResultPagingSource
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    val newsModel = MutableLiveData<NewsModel>()
    var getNewsUseCase = GetNews()

    fun onCreate(pageNumber: Int) {
        viewModelScope.launch {
            val result = getNewsUseCase(pageNumber)
            newsModel.postValue(result)
        }
    }

    val listData = Pager(PagingConfig(pageSize = 1)) {
        ResultPagingSource()
    }.flow.cachedIn(viewModelScope)
}