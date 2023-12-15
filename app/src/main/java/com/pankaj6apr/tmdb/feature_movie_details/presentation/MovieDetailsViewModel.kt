package com.pankaj6apr.tmdb.feature_movie_details.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.feature_movie_details.domain.MovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailsUseCase
): ViewModel() {
    private val _movieDetailsState = mutableStateOf(MovieDetailsState(null))
    val movieDetailsState: State<MovieDetailsState> = _movieDetailsState

    fun fetchMovieDetails(id: String) {
        viewModelScope.launch {
            movieDetailsUseCase(id).collect {
                _movieDetailsState.value = MovieDetailsState(it)
            }
        }
    }
}