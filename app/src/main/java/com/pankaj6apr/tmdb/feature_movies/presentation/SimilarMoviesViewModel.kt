package com.pankaj6apr.tmdb.feature_movies.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.feature_movies.domain.use_case.GetSimilarMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SimilarMoviesViewModel @Inject constructor(
    private val getSimilarMovies: GetSimilarMoviesUseCase
) : ViewModel() {
    private val _similarMoviesState = mutableStateOf(TrendingMoviesState())
    val similarMoviesState: State<TrendingMoviesState> = _similarMoviesState

    fun fetchSimilarMovies(id: String) {
        viewModelScope.launch {
            getSimilarMovies(id).collect {
                _similarMoviesState.value = TrendingMoviesState(it)
            }

        }
    }
}