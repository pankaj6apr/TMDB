package com.pankaj6apr.tmdb.di

import com.pankaj6apr.tmdb.common.Constants
import com.pankaj6apr.tmdb.feature_details.data.remote.MovieDetailsAPI
import com.pankaj6apr.tmdb.feature_details.data.repository.MovieDetailsRepositoryImpl
import com.pankaj6apr.tmdb.feature_details.domain.MovieDetailsRepository
import com.pankaj6apr.tmdb.feature_trending.data.remote.TrendingMoviesAPI
import com.pankaj6apr.tmdb.feature_trending.data.repository.TrendingMoviesRepositoryImpl
import com.pankaj6apr.tmdb.feature_trending.domain.repository.TrendingMoviesRepository
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
    fun provideTrendingMoviesApi(): TrendingMoviesAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TrendingMoviesAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideTrendingMoviesRepository(api: TrendingMoviesAPI): TrendingMoviesRepository {
        return TrendingMoviesRepositoryImpl(api)
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
}