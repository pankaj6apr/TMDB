package com.pankaj6apr.tmdb.feature_movie_details.data.repository

import com.pankaj6apr.tmdb.feature_movie_details.data.model.toMovieDetails
import com.pankaj6apr.tmdb.feature_movie_details.data.remote.MovieDetailsAPI
import com.pankaj6apr.tmdb.feature_movie_details.domain.MovieDetailsRepository
import com.pankaj6apr.tmdb.feature_movie_details.domain.model.MovieDetails
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(private val api: MovieDetailsAPI) : MovieDetailsRepository {
    override suspend fun getMovieDetails(id: String): MovieDetails {
        return api.getMovieDetails(id).toMovieDetails()
    }
}