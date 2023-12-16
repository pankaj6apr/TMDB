package com.pankaj6apr.tmdb.feature_movies.presentation.components.movieList

import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies

data class MoviesListState(
    val movies: Movies = Movies(),
    val isLoading: Boolean = false,
    val message: String = ""
)
