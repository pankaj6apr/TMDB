package com.pankaj6apr.tmdb.feature_movies.data.repository

import com.pankaj6apr.tmdb.feature_movies.data.model.toMovies
import com.pankaj6apr.tmdb.feature_movies.data.remote.MoviesAPI
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import com.pankaj6apr.tmdb.feature_movies.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor (private val api: MoviesAPI) : MoviesRepository {
    override suspend fun getTrendingMovies(): Movies {
        return api.getTrendingMovies().toMovies()
    }
    override suspend fun getSimilarMovies(id: String): Movies {
        return api.getSimilarMovies(id).toMovies()
    }

    override suspend fun searchMovies(keyword: String): Movies {
        return api.searchMovie(keyword).toMovies()
    }
}