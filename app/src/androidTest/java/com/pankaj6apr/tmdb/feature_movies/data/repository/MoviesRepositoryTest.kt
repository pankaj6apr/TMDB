package com.pankaj6apr.tmdb.feature_movies.data.repository

import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movie
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import com.pankaj6apr.tmdb.feature_movies.domain.repository.MoviesRepository

class MoviesRepositoryTest : MoviesRepository {

    override suspend fun getTrendingMovies(): Resource<Movies> {

        var movie = Movie(
            id = 1233,
            title = "Doctor Who",
            mediaType = "TV",
            overview = "Sci-fi TV series",
            posterPath = "upmXGc1QovmPBU0mQJR2re6ruKd.jpg",
            releaseDate = "2023-01-01",
            voteAverage = 8.2
        )

        return Resource.Success(
            Movies(
                listOf(
                    movie
                )
            )
        )
    }

    override suspend fun getSimilarMovies(id: String): Resource<Movies> {
        return Resource.Success(
            Movies(
                listOf()
            )
        )
    }

    override suspend fun searchMovies(keyword: String): Resource<Movies> {
        var movie: Movie? = null
        if (keyword.equals("Big Bang")) {
            movie = Movie(
                id = 1233,
                title = "Big Bang Theory",
                mediaType = "TV",
                overview = "Comedy TV series",
                posterPath = "upmXGc1QovmPBU0mQJR2re6ruKd.jpg",
                releaseDate = "2023-01-01",
                voteAverage = 8.2
            )
        }
        return Resource.Success(
            Movies(
                listOf(
                    movie!!
                )
            )
        )
    }

}