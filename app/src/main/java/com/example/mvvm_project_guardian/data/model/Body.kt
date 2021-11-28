package com.example.mvvm_project_guardian.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Body (
    var id: String?,
    var bodyHtml: String?,
    var bodyTextSummary: String?,
    var attributes: Attributes?,
    var published: Boolean?,
    var createdDate: String?,
    var lastModifiedDate: String?,
    var contributors: List<Any>?,
    var elements: List<Element>?
    )