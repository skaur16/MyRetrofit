package com.example.myretrofit

import com.example.myretrofit.ui.data.QuoteData
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {

    @GET("quotes")
    suspend fun getQuotes() : Response<QuoteData>
}