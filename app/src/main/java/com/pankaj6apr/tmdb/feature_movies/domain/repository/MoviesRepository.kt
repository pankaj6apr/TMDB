package com.pankaj6apr.tmdb.feature_movies.domain.repository

import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies

interface MoviesRepository {
    suspend fun getTrendingMovies(): Resource<Movies>
    suspend fun getSimilarMovies(id: String): Resource<Movies>
    suspend fun searchMovies(keyword: String): Resource<Movies>
}