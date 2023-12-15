package com.pankaj6apr.tmdb.feature_like.domain

import com.pankaj6apr.tmdb.feature_like.domain.repository.LikesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddLikeUseCase @Inject constructor(
    private val repository: LikesRepository
) {
    suspend operator fun invoke(id: String) {
        repository.addLike(id)
    }
}