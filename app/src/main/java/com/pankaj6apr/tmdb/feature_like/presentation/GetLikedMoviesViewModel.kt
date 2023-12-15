package com.pankaj6apr.tmdb.feature_like.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.feature_like.domain.GetLikedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetLikedMoviesViewModel @Inject constructor(
    private val getLikedMoviesUseCase: GetLikedMoviesUseCase,
) : ViewModel() {

    private val _likedState = mutableStateOf(LikedMoviesState())
    val likedState: State<LikedMoviesState> = _likedState

    init {
        viewModelScope.launch {
            getLikedMoviesUseCase().collect {
                _likedState.value = LikedMoviesState(it.toSet())
            }
        }
    }
}