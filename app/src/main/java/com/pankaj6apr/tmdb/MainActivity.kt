package com.pankaj6apr.tmdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pankaj6apr.tmdb.feature_details.presentation.MovieDetailsScreen
import com.pankaj6apr.tmdb.feature_trending.presentation.TrendingMoviesScreen
import com.pankaj6apr.tmdb.ui.theme.TmdbTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TmdbTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.TrendingMoviesScreen.route) {
        composable(route = Screen.TrendingMoviesScreen.route) {
            TrendingMoviesScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetailsScreen.route + "?movieId={movieId}",
            arguments = listOf(
                navArgument(
                    name = "movieId"
                ) {
                    type = NavType.StringType
                }
            )
        ) {
            val id = it.arguments?.getString("movieId") ?: ""
            MovieDetailsScreen(
                navController = navController,
                id = id
            )
        }
    }
}

