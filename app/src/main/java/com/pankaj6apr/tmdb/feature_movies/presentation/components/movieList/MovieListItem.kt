package com.pankaj6apr.tmdb.feature_movies.presentation.components.movieList

data class MovieListItem(
    val id: String = "",
    val name: String,
    val label1: String? = null,
    val label2: String? = null,
    val picturePath: String?,
    var liked: Boolean = false
)
