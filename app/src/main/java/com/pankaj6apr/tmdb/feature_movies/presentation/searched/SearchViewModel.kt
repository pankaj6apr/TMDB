package com.pankaj6apr.tmdb.feature_movies.presentation.searched

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.feature_movies.domain.use_case.GetTrendingMoviesUseCase
import com.pankaj6apr.tmdb.feature_movies.domain.use_case.SearchMoviesUseCase
import com.pankaj6apr.tmdb.feature_movies.presentation.TrendingMoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {
    private val _searchedMoviesState = mutableStateOf(TrendingMoviesState())
    val searchedMoviesState: State<TrendingMoviesState> = _searchedMoviesState

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private var searchJob: Job? = null

    fun onSearch(query: String) {
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            searchMoviesUseCase(query).collect {
                _searchedMoviesState.value = TrendingMoviesState(it)
            }
        }
    }
}