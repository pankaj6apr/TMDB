package com.pankaj6apr.tmdb.feature_movies.data.repository

import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movies.data.model.TrendingMoviesDto
import com.pankaj6apr.tmdb.feature_movies.data.model.toMovies
import com.pankaj6apr.tmdb.feature_movies.data.remote.MoviesAPI
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import com.pankaj6apr.tmdb.feature_movies.domain.repository.MoviesRepository
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor (private val api: MoviesAPI) : MoviesRepository {
    private fun handleResponse(response: Response<TrendingMoviesDto>) : Resource<Movies> {
        return if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.toMovies())
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            Resource.Error(errorObj.getString("status_message"))
        } else {
            Resource.Error("Something went wrong")
        }
    }
    override suspend fun getTrendingMovies(): Resource<Movies> {
        val response = api.getTrendingMovies()
        return handleResponse(response)
    }
    override suspend fun getSimilarMovies(id: String): Resource<Movies> {
        val response = api.getSimilarMovies(id)
        return handleResponse(response)
    }

    override suspend fun searchMovies(keyword: String): Resource<Movies> {
        val response = api.searchMovie(keyword)
        return handleResponse(response)
    }
}