package com.pankaj6apr.tmdb.feature_like.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pankaj6apr.tmdb.feature_like.domain.model.LikesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LikesDao {
    @Query("SELECT * FROM LikesEntity")
    fun getLikedMovies(): Flow<List<LikesEntity>>

    @Query("SELECT * FROM LikesEntity WHERE id = :id")
    suspend fun getLikeById(id: String): LikesEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLike(entity: LikesEntity)

    @Delete
    suspend fun deleteLike(entity: LikesEntity)
}