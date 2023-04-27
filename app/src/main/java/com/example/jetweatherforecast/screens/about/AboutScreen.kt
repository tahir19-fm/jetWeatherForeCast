package com.example.jetweatherforecast.screens.about

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.jetweatherforecast.R
import com.example.jetweatherforecast.widgets.WeatherAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AboutScreen(navController: NavController){
    Scaffold(topBar = { WeatherAppBar(
        title="About",
        isMainScreen = false,
        navController = navController,
    icon =Icons.Default.ArrowBack ){
        navController.popBackStack()
    }
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = stringResource(id = R.string.about_app),
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold)
                Text(text = stringResource(id = R.string.api_used),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Light)
            }
        }
    }
}