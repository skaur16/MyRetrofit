package com.example.myretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myretrofit.ui.data.QuoteData
import com.example.myretrofit.ui.data.ResultData
import com.example.myretrofit.ui.theme.MyRetrofitTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel: MainViewModel by viewModels()

        setContent {


            MyRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val nav = rememberNavController()
                    NavHost(navController = nav, startDestination = "main_activity") {
                        composable("main_activity") { Show(mainViewModel, nav) }
                        composable("display_quotes") { DisplayQuotes(mainViewModel, nav) }
                        composable("display_quote_details") { QuoteDetails(nav, mainViewModel) }
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Show(mainViewModel: MainViewModel, nav: NavHostController) {

            Row() {
                TopAppBar(title = {
                    Text(text = "Home")
                    TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Green)
                }

                )
            }


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                val quotes = RetrofitObject.getInstance().create(QuotesApi::class.java)
                GlobalScope.launch {
                    val result = quotes.getQuotes()
                    if (result != null) {
                        Log.e("Log", mainViewModel.listOfQuotes.value.toString())
                        mainViewModel.listOfQuotes.value =
                            result.body()?.results as MutableList<ResultData>
                        Log.e("Log", mainViewModel.listOfQuotes.value.toString())

                    } else {
                        Log.e("Null", "No data ..")
                    }

                }
                nav.navigate("display_quotes")
            }) {
                Text(text = "Display All Quotes")
            }
        }
    }

