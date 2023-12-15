package com.pankaj6apr.tmdb.feature_trending.data.model

import com.pankaj6apr.tmdb.feature_trending.domain.model.Movie

data class MovieDto(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun MovieDto.toMovie(): Movie {
    return Movie(
        adult = adult,
        backdropPath = backdrop_path,
        genreIds = genre_ids,
        id = id,
        mediaType = media_type,
        originalLanguage = original_language,
        originalTitle = original_title,
        overview = overview,
        popularity = popularity,
        posterPath = poster_path,
        releaseDate = release_date,
        title = title,
        video = video,
        voteAverage = vote_average,
        voteCount = vote_count
    )
}