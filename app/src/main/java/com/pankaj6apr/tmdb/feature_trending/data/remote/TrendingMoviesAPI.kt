package com.pankaj6apr.tmdb.feature_trending.data.remote

import com.pankaj6apr.tmdb.common.Constants
import com.pankaj6apr.tmdb.feature_trending.data.model.TrendingMoviesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingMoviesAPI {
    @GET("3/trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): TrendingMoviesDto
}