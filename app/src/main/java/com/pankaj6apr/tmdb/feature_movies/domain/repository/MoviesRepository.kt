package com.pankaj6apr.tmdb.feature_movies.domain.repository

import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies

interface MoviesRepository {
    suspend fun getTrendingMovies(): Movies
    suspend fun getSimilarMovies(id: String): Movies
    suspend fun searchMovies(keyword: String): Movies
}