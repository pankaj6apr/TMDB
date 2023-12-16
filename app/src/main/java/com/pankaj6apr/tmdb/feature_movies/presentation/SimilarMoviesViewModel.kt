package com.pankaj6apr.tmdb.feature_movies.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import com.pankaj6apr.tmdb.feature_movies.domain.use_case.GetSimilarMoviesUseCase
import com.pankaj6apr.tmdb.feature_movies.presentation.components.movieList.MoviesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SimilarMoviesViewModel @Inject constructor(
    private val getSimilarMovies: GetSimilarMoviesUseCase
) : ViewModel() {
    private val _similarMoviesState = mutableStateOf(MoviesListState())
    val similarMoviesState: State<MoviesListState> = _similarMoviesState

    fun fetchSimilarMovies(id: String) {
        viewModelScope.launch {
            getSimilarMovies(id).collect {
                when(it) {
                    is Resource.Success -> {
                        _similarMoviesState.value = MoviesListState(
                            movies = it.data ?: Movies(),
                            message = if (it.data?.movies?.isNotEmpty() == true) "" else "No result"
                        )
                    }
                    is Resource.Error -> {
                        _similarMoviesState.value = MoviesListState(message = it.message ?: "An unexpected error occurred")
                    }
                    is Resource.Loading -> {
                        _similarMoviesState.value = MoviesListState(isLoading = true)
                    }
                }
            }
        }
    }
}