package com.pankaj6apr.tmdb.feature_trending.data.model

import com.pankaj6apr.tmdb.feature_trending.domain.model.TrendingMovies

data class TrendingMoviesDto(
    val results: List<MovieDto> = emptyList()
)

fun TrendingMoviesDto.toTrendingMovies() : TrendingMovies {
    return TrendingMovies(
        movies = results.map {
            it.toMovie()
        }
    )
}
