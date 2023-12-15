package com.pankaj6apr.tmdb.feature_trending.domain.repository

import com.pankaj6apr.tmdb.feature_trending.domain.model.TrendingMovies

interface TrendingMoviesRepository {
    suspend fun getTrendingMovies(): TrendingMovies
}