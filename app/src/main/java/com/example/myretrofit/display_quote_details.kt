package com.example.myretrofit

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.nio.file.WatchEvent.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteDetails(nav:NavHostController,mainViewModel: MainViewModel) {
   Column(){
    TopAppBar(title = {
        Text(text = "Details")
        TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Green)
    })

    Card(
        border = BorderStroke(2.dp, Color.Black)
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            )
        {
                Row() {
                    Text(text = "Id: ${mainViewModel.resultData.value._id}")
                }
            Divider(thickness = 2.dp,color = Color.Black)
            Row() {
                    Text(text = "Author : ${mainViewModel.resultData.value.author}")
                }
            Divider(thickness = 2.dp,color = Color.Black)
            Row() {
                Text(text = "Authorslug : ${mainViewModel.resultData.value.authorSlug}")
                }
            Divider(thickness = 2.dp,color = Color.Black)
            Row() {
                Text(text = "Content : ${mainViewModel.resultData.value.content}")
                }
            Divider(thickness = 2.dp,color = Color.Black)
            Row() {
                Text(text = "Date Added : ${mainViewModel.resultData.value.dateAdded}")
                }
            Divider(thickness = 2.dp,color = Color.Black)
            Row() {
                Text(text = "Date Modified : ${mainViewModel.resultData.value.dateModified}")
                }
            Divider(thickness = 2.dp,color = Color.Black)
            Row() {
                Text(text = "Java Class : ${mainViewModel.resultData.value.javaClass}")
                }
            Divider(thickness = 2.dp,color = Color.Black)
            Row() {
                Text(text = "Length : ${mainViewModel.resultData.value.length}")
                }
            Divider(thickness = 2.dp,color = Color.Black)










        }
        }
    }
}