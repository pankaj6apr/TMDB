package com.pankaj6apr.tmdb.feature_movies.domain.use_case

import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import com.pankaj6apr.tmdb.feature_movies.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(keyword: String) : Flow<Resource<Movies>> = flow {
            emit(Resource.Loading())
            emit(repository.searchMovies(keyword))
    }
}
