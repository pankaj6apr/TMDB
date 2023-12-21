package com.pankaj6apr.tmdb.di

import android.app.Application
import androidx.room.Room
import com.pankaj6apr.tmdb.feature_like.data.model.LikesDatabase
import com.pankaj6apr.tmdb.feature_like.data.repository.LikesRepositoryImpl
import com.pankaj6apr.tmdb.feature_like.domain.repository.LikesRepository
import com.pankaj6apr.tmdb.feature_movie_details.data.repository.MovieDetailsRepositoryImpl
import com.pankaj6apr.tmdb.feature_movie_details.domain.MovieDetailsRepository
import com.pankaj6apr.tmdb.feature_movies.data.repository.MovieDetailsRepositoryTest
import com.pankaj6apr.tmdb.feature_movies.data.repository.MoviesRepositoryTest
import com.pankaj6apr.tmdb.feature_movies.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object TestAppModule {
//    @Provides
//    @Singleton
//    fun provideTrendingMoviesApi(): MoviesAPI {
//        val mockWebServer = MockWebServer()
//        return Retrofit.Builder()
//            .baseUrl(mockWebServer.url(""))
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(MoviesAPI::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideMovieDetailsApi(): MovieDetailsAPI {
//        val mockWebServer = MockWebServer()
//        return Retrofit.Builder()
//            .baseUrl(mockWebServer.url(""))
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(MovieDetailsAPI::class.java)
//    }

    @Provides
    @Singleton
    fun provideMoviesRepository(): MoviesRepository {
        return MoviesRepositoryTest()
    }

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(): MovieDetailsRepository {
        return MovieDetailsRepositoryTest()
    }

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): LikesDatabase {
        return Room
            .inMemoryDatabaseBuilder(
                app,
                LikesDatabase::class.java
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideLikesRepository(db: LikesDatabase): LikesRepository {
        return LikesRepositoryImpl(db.likesDao)
    }
//
//    @Provides
//    @Singleton
//    fun provideAddLikesUseCaseTest(repository: FakeLikesRepository): AddLikeUseCaseTest {
//        return AddLikeUseCaseTest(repository)
//    }
}