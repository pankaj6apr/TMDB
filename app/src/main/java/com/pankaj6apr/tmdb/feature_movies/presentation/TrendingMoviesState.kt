package com.pankaj6apr.tmdb.feature_movies.presentation

import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies

data class TrendingMoviesState(
    val movies: Movies = Movies()
)
