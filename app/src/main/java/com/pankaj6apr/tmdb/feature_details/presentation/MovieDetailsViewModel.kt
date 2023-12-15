package com.pankaj6apr.tmdb.feature_details.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.feature_details.domain.MovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailsUseCase
): ViewModel() {
    private val _movieDetailsState = mutableStateOf(MovieDetailsState(null))
    val movieDetailsState: State<MovieDetailsState> = _movieDetailsState

    private val _movieId = mutableStateOf("")
    val movieId: State<String> = _movieId


    fun saveMovieid(id: String) {
        _movieId.value = id
        viewModelScope.launch {
            movieDetailsUseCase(movieId.value).collect {
                _movieDetailsState.value = MovieDetailsState(it)
            }
        }
    }
}