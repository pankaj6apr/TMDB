package com.pankaj6apr.tmdb.feature_movies.domain.use_case

import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import com.pankaj6apr.tmdb.feature_movies.domain.repository.TrendingMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSimilarMoviesUseCase @Inject constructor(
    private val repository: TrendingMoviesRepository
) {
    operator fun invoke(id: String) : Flow<Movies> = flow {
        emit(repository.getSimilarMovies(id))
    }
}
