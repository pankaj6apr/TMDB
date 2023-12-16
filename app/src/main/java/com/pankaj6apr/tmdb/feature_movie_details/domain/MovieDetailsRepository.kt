package com.pankaj6apr.tmdb.feature_movie_details.domain

import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movie_details.domain.model.MovieDetails

interface MovieDetailsRepository {
    suspend fun getMovieDetails(id: String) : Resource<MovieDetails>
}