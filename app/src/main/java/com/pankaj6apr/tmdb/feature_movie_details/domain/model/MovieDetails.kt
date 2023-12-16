package com.pankaj6apr.tmdb.feature_movie_details.domain.model

import com.pankaj6apr.tmdb.feature_movies.presentation.components.movieList.MovieListItem

data class MovieDetails (
    val id: String,
    val name: String,
    val overview: String,
    val posterPath: String,
    val votePercentage: Int,
    val genres: String,
    val seasons: List<MovieListItem>
)