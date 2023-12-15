package com.pankaj6apr.tmdb.feature_movies.data.repository

import com.pankaj6apr.tmdb.feature_movies.data.model.toMovies
import com.pankaj6apr.tmdb.feature_movies.data.remote.MoviesAPI
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import com.pankaj6apr.tmdb.feature_movies.domain.repository.TrendingMoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor (private val api: MoviesAPI) : TrendingMoviesRepository {
    override suspend fun getTrendingMovies(): Movies {
        return api.getTrendingMovies().toMovies()
    }
    override suspend fun getSimilarMovies(id: String): Movies {
        return api.getSimilarMovies(id).toMovies()
    }
}