package com.pankaj6apr.tmdb.feature_movies.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import com.pankaj6apr.tmdb.feature_movies.domain.use_case.GetTrendingMoviesUseCase
import com.pankaj6apr.tmdb.feature_movies.presentation.components.movieList.MoviesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingMoviesViewModel @Inject constructor(
    private val getTrendingMovies: GetTrendingMoviesUseCase
) : ViewModel() {
    private val _MoviesListState = mutableStateOf(MoviesListState())
    val moviesListState: State<MoviesListState> = _MoviesListState

    init {
        viewModelScope.launch {
            getTrendingMovies().collect {
                when (it) {
                    is Resource.Success -> {
                        _MoviesListState.value = MoviesListState(
                            movies = it.data ?: Movies(),
                            message = if (it.data?.movies?.isNotEmpty() == true) "" else "No result"
                        )
                    }

                    is Resource.Error -> {
                        _MoviesListState.value = MoviesListState(
                            message = it.message ?: "An unexpected error occurred"
                        )
                    }

                    is Resource.Loading -> {
                        _MoviesListState.value = MoviesListState(isLoading = true)
                    }
                }
            }
        }
    }
}