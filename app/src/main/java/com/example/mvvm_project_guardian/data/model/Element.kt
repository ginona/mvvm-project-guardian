package com.example.mvvm_project_guardian.data.model

data class Element (
    var type: String?,

    var assets: List<Asset>,

    var textTypeData: TextTypeData,

    var richLinkTypeData: RichLinkTypeData,

    var imageTypeData: ImageTypeData?,
        )