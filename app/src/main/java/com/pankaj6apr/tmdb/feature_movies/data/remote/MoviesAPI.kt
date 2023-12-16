package com.pankaj6apr.tmdb.feature_movies.data.remote

import com.pankaj6apr.tmdb.common.Constants
import com.pankaj6apr.tmdb.feature_movies.data.model.TrendingMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {
    @GET("3/trending/tv/week")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): TrendingMoviesDto

    @GET("3/tv/{id}/similar")
    suspend fun getSimilarMovies(
        @Path("id") id: String,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): TrendingMoviesDto


    @GET("3/search/tv")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): TrendingMoviesDto
}