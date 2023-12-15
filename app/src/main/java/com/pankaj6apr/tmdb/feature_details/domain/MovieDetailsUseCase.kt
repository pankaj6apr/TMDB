package com.pankaj6apr.tmdb.feature_details.domain

import com.pankaj6apr.tmdb.feature_details.domain.model.MovieDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(
    private val repository: MovieDetailsRepository
) {
    operator fun invoke(id: String) : Flow<MovieDetails> = flow {
        emit(repository.getMovieDetails(id))
    }
}