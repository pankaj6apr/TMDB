package com.pankaj6apr.tmdb.feature_details.data.model

import com.pankaj6apr.tmdb.feature_details.domain.model.MovieDetails
import com.pankaj6apr.tmdb.feature_trending.presentation.model.MovieListItem

data class MovieDetailsDto(
    val adult: Boolean,
    val backdrop_path: String,
    val created_by: List<CreatedBy>,
    val episode_run_time: List<Any>,
    val first_air_date: String,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val in_production: Boolean,
    val languages: List<String>,
    val last_air_date: String,
    val last_episode_to_air: LastEpisodeToAir,
    val name: String,
    val networks: List<Network>,
    val next_episode_to_air: Any,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val seasons: List<Season>,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int
)

fun MovieDetailsDto.toMovieDetails() : MovieDetails {
    return MovieDetails(
        name = name,
        overview = overview,
        posterPath = poster_path,
        votePercentage = (vote_average * 10).toInt(),
        genres = genres.map {
            it.name
        }.joinToString(),
        seasons = seasons.map {
            MovieListItem(
                id = it.id,
                name = it.name,
                label1 = "${it.episode_count} episodes",
                picturePath = it.poster_path
            )
        }
    )
}