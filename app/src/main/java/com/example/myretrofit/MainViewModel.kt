package com.example.myretrofit

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myretrofit.ui.data.ResultData

class MainViewModel :ViewModel() {
    var listOfQuotes = mutableStateOf(mutableListOf<ResultData>())
}