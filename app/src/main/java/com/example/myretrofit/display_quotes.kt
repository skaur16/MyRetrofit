package com.example.myretrofit

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayQuotes(mainViewModel:MainViewModel) {
    Log.e("DISPLAYQUOTES", mainViewModel.listOfQuotes.value.toString())

    Column() {


        TopAppBar(title = {
            Text(text = "Quotes")
            TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Green)
        })


        LazyColumn() {
            items(mainViewModel.listOfQuotes.value) {
                QuoteView(quote = it.content.toString())
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteView(quote:String) {
    TextField(value = quote, onValueChange = {})
}