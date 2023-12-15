package com.pankaj6apr.tmdb.feature_like.domain

import com.pankaj6apr.tmdb.feature_like.domain.repository.LikesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetLikedMoviesUseCase @Inject constructor(
    private val repository: LikesRepository
) {
    operator fun invoke(): Flow<List<String>> {
        return repository.getLikedMovies().map {
            it.map {
                it.id
            }
        }
    }
}