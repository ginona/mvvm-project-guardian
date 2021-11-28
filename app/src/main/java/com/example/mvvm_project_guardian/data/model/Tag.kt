package com.example.mvvm_project_guardian.data.model

import java.util.*

data class Tag (
    val id: String?,
    val type: String?,
    val webTitle: String?,
    val webUrl: String?,
    val apiUrl: String?,
    val references: List<Objects?>?,
    val bio: String?,
    val bylineImageUrl: String?,
    val firstName: String?,
    val lastName: String?,
    val emailAddress: String?,
    val twitterHandle: String?,
)