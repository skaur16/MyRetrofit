package com.example.myretrofit.ui.data

data class QuoteData(
    val count: Int ,
    val lastItemIndex: Int ,
    val page: Int ,
    val results: List<ResultData>,
    val totalCount: Int,
    val totalPages: Int
)