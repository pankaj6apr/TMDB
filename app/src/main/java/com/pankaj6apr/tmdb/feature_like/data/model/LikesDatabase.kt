package com.pankaj6apr.tmdb.feature_like.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pankaj6apr.tmdb.feature_like.domain.model.LikesEntity

@Database(
    entities = [LikesEntity::class],
    version = 1
)
abstract class LikesDatabase : RoomDatabase() {

    abstract val likesDao: LikesDao

    companion object {
        const val DATABASE_NAME = "likes_db"
    }
}
