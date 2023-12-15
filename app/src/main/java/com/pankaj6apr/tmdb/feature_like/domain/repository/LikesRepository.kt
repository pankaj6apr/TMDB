package com.pankaj6apr.tmdb.feature_like.domain.repository

import com.pankaj6apr.tmdb.feature_like.domain.model.LikesEntity
import kotlinx.coroutines.flow.Flow

interface LikesRepository {
    fun getLikedMovies(): Flow<List<LikesEntity>>
    suspend fun addLike(id: String)
    suspend fun deleteLike(id: String)
}