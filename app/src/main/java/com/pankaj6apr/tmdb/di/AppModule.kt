package com.pankaj6apr.tmdb.di

import android.app.Application
import androidx.room.Room
import com.pankaj6apr.tmdb.common.Constants
import com.pankaj6apr.tmdb.feature_like.data.model.LikesDatabase
import com.pankaj6apr.tmdb.feature_like.data.repository.LikesRepositoryImpl
import com.pankaj6apr.tmdb.feature_like.domain.repository.LikesRepository
import com.pankaj6apr.tmdb.feature_movie_details.data.remote.MovieDetailsAPI
import com.pankaj6apr.tmdb.feature_movie_details.data.repository.MovieDetailsRepositoryImpl
import com.pankaj6apr.tmdb.feature_movie_details.domain.MovieDetailsRepository
import com.pankaj6apr.tmdb.feature_movies.data.remote.MoviesAPI
import com.pankaj6apr.tmdb.feature_movies.data.repository.MoviesRepositoryImpl
import com.pankaj6apr.tmdb.feature_movies.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTrendingMoviesApi(): MoviesAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideTrendingMoviesRepository(api: MoviesAPI): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideMovieDetailsApi(): MovieDetailsAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDetailsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(api: MovieDetailsAPI): MovieDetailsRepository {
        return MovieDetailsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): LikesDatabase {
        return Room.databaseBuilder(
            app,
            LikesDatabase::class.java,
            LikesDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideLikesRepository(db: LikesDatabase): LikesRepository {
        return LikesRepositoryImpl(db.likesDao)
    }
}