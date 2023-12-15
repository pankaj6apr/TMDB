package com.pankaj6apr.tmdb.feature_trending.data.repository

import com.pankaj6apr.tmdb.feature_trending.data.model.toTrendingMovies
import com.pankaj6apr.tmdb.feature_trending.data.remote.TrendingMoviesAPI
import com.pankaj6apr.tmdb.feature_trending.domain.model.TrendingMovies
import com.pankaj6apr.tmdb.feature_trending.domain.repository.TrendingMoviesRepository
import javax.inject.Inject

class TrendingMoviesRepositoryImpl @Inject constructor (private val api: TrendingMoviesAPI) : TrendingMoviesRepository {
    override suspend fun getTrendingMovies(): TrendingMovies {
        return api.getTrendingMovies().toTrendingMovies()
    }

}