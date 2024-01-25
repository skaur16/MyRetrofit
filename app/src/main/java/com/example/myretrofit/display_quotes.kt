package com.example.myretrofit

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myretrofit.ui.data.ResultData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayQuotes(mainViewModel:MainViewModel,nav: NavHostController) {
    Log.e("DISPLAYQUOTES", mainViewModel.listOfQuotes.value.toString())

    Column() {


        TopAppBar(title = {
            Text(text = "Quotes")
            TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Green)
        })


        LazyColumn() {
            items(mainViewModel.listOfQuotes.value) {
                Log.e("It",it.toString())


                Log.e("It",mainViewModel.resultData.value.toString())
                QuoteView( it,nav,mainViewModel)
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteView(result:ResultData,nav:NavHostController,mainViewModel: MainViewModel) {
    Row() {
        Column() {
            Text(text = result.content)
            Button(onClick = {

                mainViewModel.resultData.value = mainViewModel.resultData.value.copy(
                    _id = result._id,
                 author = result.author,
                 authorSlug = result.authorSlug,
                 content = result.content,
                 dateAdded = result.dateAdded,
                 dateModified = result.dateModified,
                 length = result.length,
                 tags = result.tags
                )
                nav.navigate("display_quote_details") }) {
                Text(text = "Details")
            }

        }
    }
    Divider(thickness = 2.dp, color = Color.Black)

}