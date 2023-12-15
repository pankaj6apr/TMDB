package com.pankaj6apr.tmdb.feature_movies.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.feature_movies.domain.use_case.GetTrendingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingMoviesViewModel @Inject constructor (
    private val getTrendingMovies: GetTrendingMoviesUseCase
): ViewModel() {
    private val _trendingMoviesState = mutableStateOf(TrendingMoviesState())
    val trendingMoviesState: State<TrendingMoviesState> = _trendingMoviesState

    init {
        viewModelScope.launch {
            getTrendingMovies().collect {
                _trendingMoviesState.value = TrendingMoviesState(it)
            }
        }
    }
}