package com.pankaj6apr.tmdb.feature_movie_details.data.repository

import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movie_details.data.model.MovieDetailsDto
import com.pankaj6apr.tmdb.feature_movie_details.data.model.toMovieDetails
import com.pankaj6apr.tmdb.feature_movie_details.data.remote.MovieDetailsAPI
import com.pankaj6apr.tmdb.feature_movie_details.domain.MovieDetailsRepository
import com.pankaj6apr.tmdb.feature_movie_details.domain.model.MovieDetails
import com.pankaj6apr.tmdb.feature_movies.data.model.TrendingMoviesDto
import com.pankaj6apr.tmdb.feature_movies.data.model.toMovies
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(private val api: MovieDetailsAPI) : MovieDetailsRepository {
    private fun handleResponse(response: Response<MovieDetailsDto>) : Resource<MovieDetails> {
        return if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.toMovieDetails())
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            Resource.Error(errorObj.getString("status_message"))
        } else {
            Resource.Error("Something went wrong")
        }
    }
    override suspend fun getMovieDetails(id: String): Resource<MovieDetails> {
        val response = api.getMovieDetails(id)
        return handleResponse(response)
    }
}