package com.pankaj6apr.tmdb.feature_like.data.repository

import com.pankaj6apr.tmdb.feature_like.data.model.LikesDao
import com.pankaj6apr.tmdb.feature_like.domain.model.LikesEntity
import com.pankaj6apr.tmdb.feature_like.domain.repository.LikesRepository
import kotlinx.coroutines.flow.Flow

class LikesRepositoryImpl(private val dao: LikesDao) : LikesRepository {
    override fun getLikedMovies(): Flow<List<LikesEntity>> {
        return dao.getLikedMovies()
    }

    override suspend fun addLike(id: String) {
        dao.insertLike(LikesEntity(id))
    }

    override suspend fun deleteLike(id: String) {
        dao.deleteLike(LikesEntity(id))
    }
}