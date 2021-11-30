package com.example.mvvm_project_guardian.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.mvvm_project_guardian.data.network.NewsService
import com.example.mvvm_project_guardian.paging.ResultPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel()
class NewsPagingViewModel
@Inject constructor(val newsService: NewsService): ViewModel() {

}