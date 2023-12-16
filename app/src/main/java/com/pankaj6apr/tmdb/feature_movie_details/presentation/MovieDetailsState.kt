package com.pankaj6apr.tmdb.feature_movie_details.presentation

import com.pankaj6apr.tmdb.feature_movie_details.domain.model.MovieDetails

data class MovieDetailsState (
    val movieDetails: MovieDetails?,
    val isLoading: Boolean = false,
    val message: String = ""
)