package com.example.mvvm_project_guardian.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mvvm_project_guardian.data.model.Result
import com.example.mvvm_project_guardian.domain.GetNews

class ResultPagingSource(): PagingSource<Int, Result>() {
    var getNewsUseCase = GetNews()

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = getNewsUseCase(nextPageNumber)
            val data = response.response.results ?: emptyList()
            val responseData = mutableListOf<Result>()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1, // Only paging forward.
                nextKey = nextPageNumber.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}