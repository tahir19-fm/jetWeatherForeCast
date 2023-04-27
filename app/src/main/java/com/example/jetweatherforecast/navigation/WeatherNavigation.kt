package com.example.jetweatherforecast.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.screens.about.AboutScreen
import com.example.jetweatherforecast.screens.favorites.FavoritesScreen
import com.example.jetweatherforecast.screens.main.MainScreen
import com.example.jetweatherforecast.screens.search.SearchScreen
import com.example.jetweatherforecast.screens.setting.SettingScreen
import com.example.jetweatherforecast.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SplashScreen.name){
        val route=WeatherScreens.MainScreen.name
        composable("$route/{city}", arguments = listOf(
            navArgument(name = "city"){
                type= NavType.StringType
            }
        )){navBack->
            navBack.arguments?.getString("city").let {city->
                MainScreen(navController=navController,city=city)
            }

        }
        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController = navController)
        }
        composable(WeatherScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }
        composable(WeatherScreens.AboutScreen.name){
            AboutScreen(navController = navController)
        }
        composable(WeatherScreens.FavoriteScreen.name){
            FavoritesScreen(navController = navController)
        }
        composable(WeatherScreens.SettingScreen.name){
            SettingScreen(navController = navController)
        }
    }
}