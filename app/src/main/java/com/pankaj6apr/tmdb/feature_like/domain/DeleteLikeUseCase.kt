package com.pankaj6apr.tmdb.feature_like.domain

import com.pankaj6apr.tmdb.feature_like.domain.repository.LikesRepository
import javax.inject.Inject

class DeleteLikeUseCase @Inject constructor(
    private val repository: LikesRepository
) {
    suspend operator fun invoke(id: String) {
        repository.deleteLike(id)
    }
}