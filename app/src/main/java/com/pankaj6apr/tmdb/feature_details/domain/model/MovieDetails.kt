package com.pankaj6apr.tmdb.feature_details.domain.model

import com.pankaj6apr.tmdb.feature_trending.presentation.model.MovieListItem

data class MovieDetails (
    val name: String,
    val overview: String,
    val posterPath: String,
    val votePercentage: Int,
    val genres: String,
    val seasons: List<MovieListItem>
)