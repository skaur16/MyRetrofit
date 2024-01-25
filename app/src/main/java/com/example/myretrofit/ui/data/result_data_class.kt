package com.example.myretrofit.ui.data

data class ResultData(
    val _id: String = "",
    val author: String = "",
    val authorSlug: String = "",
    val content: String = "",
    val dateAdded: String = "",
    val dateModified: String = "",
    val length: Int = 0,
    val tags: List<String> = listOf()
)