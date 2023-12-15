package com.pankaj6apr.tmdb.feature_movie_details.data.remote

import com.pankaj6apr.tmdb.common.Constants
import com.pankaj6apr.tmdb.feature_movie_details.data.model.MovieDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsAPI {
    @GET("3/tv/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ) : MovieDetailsDto
}