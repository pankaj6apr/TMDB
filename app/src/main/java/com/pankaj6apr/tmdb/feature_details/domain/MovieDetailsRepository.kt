package com.pankaj6apr.tmdb.feature_details.domain

import com.pankaj6apr.tmdb.feature_details.domain.model.MovieDetails

interface MovieDetailsRepository {
    suspend fun getMovieDetails(id: String) : MovieDetails
}