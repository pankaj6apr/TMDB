package com.pankaj6apr.tmdb.feature_movies.data.model

import com.pankaj6apr.tmdb.feature_movies.domain.model.Movie

data class MovieDto(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String?,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val first_air_date: String,
    val name: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        mediaType = media_type,
        overview = overview,
        posterPath = poster_path,
        releaseDate = first_air_date,
        title = name,
        voteAverage = vote_average
    )
}