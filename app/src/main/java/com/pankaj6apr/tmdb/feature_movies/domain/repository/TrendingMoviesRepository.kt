package com.pankaj6apr.tmdb.feature_movies.domain.repository

import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies

interface TrendingMoviesRepository {
    suspend fun getTrendingMovies(): Movies
    suspend fun getSimilarMovies(id: String): Movies
}