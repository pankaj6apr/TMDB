package com.pankaj6apr.tmdb.feature_trending.domain.use_case

import com.pankaj6apr.tmdb.feature_trending.domain.model.TrendingMovies
import com.pankaj6apr.tmdb.feature_trending.domain.repository.TrendingMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: TrendingMoviesRepository
) {
    operator fun invoke() : Flow<TrendingMovies> = flow {
        emit(repository.getTrendingMovies())
    }
}
