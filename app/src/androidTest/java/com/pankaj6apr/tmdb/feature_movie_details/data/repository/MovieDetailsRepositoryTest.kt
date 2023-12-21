package com.pankaj6apr.tmdb.feature_movies.data.repository

import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movie_details.domain.MovieDetailsRepository
import com.pankaj6apr.tmdb.feature_movie_details.domain.model.MovieDetails

class MovieDetailsRepositoryTest : MovieDetailsRepository {
    override suspend fun getMovieDetails(id: String): Resource<MovieDetails> {
        var movie: MovieDetails? = null
        movie = MovieDetails(
            id = "1233",
            name = "Doctor Who",
            overview = "Sci-fi TV series",
            posterPath = "upmXGc1QovmPBU0mQJR2re6ruKd.jpg",
            votePercentage = 82,
            genres = "",
            seasons = listOf()
        )

        return Resource.Success(
            movie
        )
    }
}