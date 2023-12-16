package com.pankaj6apr.tmdb.feature_movie_details.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.common.Resource
import com.pankaj6apr.tmdb.feature_movie_details.domain.MovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _movieDetailsState = mutableStateOf(MovieDetailsState(null))
    val movieDetailsState: State<MovieDetailsState> = _movieDetailsState

    init {
        savedStateHandle.get<String>("movieId").let { id ->
            viewModelScope.launch {
                movieDetailsUseCase(id!!).collect {
                    when (it) {
                        is Resource.Success -> {
                            _movieDetailsState.value = MovieDetailsState(
                                movieDetails = it.data
                            )
                        }

                        is Resource.Error -> {
                            _movieDetailsState.value = MovieDetailsState(
                                movieDetails = null,
                                message = it.message ?: "An unexpected error occurred"
                            )
                        }

                        is Resource.Loading -> {
                            _movieDetailsState.value = MovieDetailsState(
                                movieDetails = null,
                                isLoading = true
                            )
                        }
                    }
                }
            }
        }
    }
}