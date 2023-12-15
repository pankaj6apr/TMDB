package com.pankaj6apr.tmdb.feature_movies.presentation.model

data class MovieListItem(
    val id: Int? = null,
    val name: String,
    val label1: String? = null,
    val label2: String? = null,
    val picturePath: String?,
    val liked: Boolean = false
)
