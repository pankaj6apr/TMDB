package com.pankaj6apr.tmdb.feature_movies.domain.model

import com.pankaj6apr.tmdb.feature_movies.presentation.model.MovieListItem
import java.math.RoundingMode
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

data class Movie(
    val id: Int,
    val mediaType: String? = "TV",
    val overview: String,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
)

fun Movie.toMovieListItem() : MovieListItem {
    var formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
    var formattedDate = if (!releaseDate.isNullOrEmpty())
        LocalDate.parse(releaseDate).format(formatter)
    else
        null

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING

    return MovieListItem(
        id = id,
        name = title,
        label1 = formattedDate,
        label2 = df.format(voteAverage).toString() + " ✰",
        picturePath = posterPath
    )
}