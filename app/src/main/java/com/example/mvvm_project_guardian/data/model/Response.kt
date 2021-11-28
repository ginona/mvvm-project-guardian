package com.example.mvvm_project_guardian.data.model

data class Response (
    val status: String?,
    val userTier: String?,
    val total: Int?,
    val startIndex: Int?,
    val pageSize: Int?,
    val currentPage: Int?,
    val pages: Int?,
    val orderBy: String?,
    val results: List<Result>?
)