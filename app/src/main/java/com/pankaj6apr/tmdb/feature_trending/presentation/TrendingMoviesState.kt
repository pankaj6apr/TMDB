package com.pankaj6apr.tmdb.feature_trending.presentation

import com.pankaj6apr.tmdb.feature_trending.domain.model.TrendingMovies

data class TrendingMoviesState(
    val trendingMovies: TrendingMovies = TrendingMovies()
)
