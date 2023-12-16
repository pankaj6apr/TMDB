package com.pankaj6apr.tmdb.feature_movies.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movies.domain.model.Movies
import com.pankaj6apr.tmdb.feature_movies.domain.use_case.SearchMoviesUseCase
import com.pankaj6apr.tmdb.feature_movies.presentation.components.movieList.MoviesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {
    private val _searchedMoviesState = mutableStateOf(MoviesListState())
    val searchedMoviesState: State<MoviesListState> = _searchedMoviesState

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private var searchJob: Job? = null

    fun onSearch(query: String) {
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            searchMoviesUseCase.invoke(query)
                .collect {
                    when (it) {
                        is Resource.Success -> {
                            _searchedMoviesState.value =
                                MoviesListState(
                                    movies = it.data ?: Movies(),
                                    message = if (it.data?.movies?.isNotEmpty() == true) "" else "No result"
                                )
                        }

                        is Resource.Error -> {
                            _searchedMoviesState.value = MoviesListState(
                                message = it.message ?: "An unexpected error occured"
                            )
                        }

                        is Resource.Loading -> {
                            _searchedMoviesState.value = MoviesListState(isLoading = true)
                        }
                    }
                }
        }
    }
}