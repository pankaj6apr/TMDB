package com.pankaj6apr.tmdb.feature_like.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LikesEntity(
    @PrimaryKey val id: String
)
