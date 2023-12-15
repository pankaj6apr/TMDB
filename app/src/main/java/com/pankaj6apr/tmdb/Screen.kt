package com.pankaj6apr.tmdb

sealed class Screen(val route: String) {
    object TrendingMoviesScreen : Screen("trending")
    object MovieDetailsScreen : Screen("details")
}
