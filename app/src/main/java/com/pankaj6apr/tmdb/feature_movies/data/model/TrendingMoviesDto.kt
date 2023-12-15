package com.pankaj6apr.tmdb.feature_movies.data.model

import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies

data class TrendingMoviesDto(
    val results: List<MovieDto> = emptyList()
)

fun TrendingMoviesDto.toMovies() : Movies {
    return Movies(
        movies = results.map {
            it.toMovie()
        }
    )
}
