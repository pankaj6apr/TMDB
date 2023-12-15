package com.pankaj6apr.tmdb.feature_like.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.tmdb.feature_like.domain.AddLikeUseCase
import com.pankaj6apr.tmdb.feature_like.domain.DeleteLikeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRemoveLikeViewModel @Inject constructor(
    private val addLikeUseCase: AddLikeUseCase,
    private val deleteLikeUseCase: DeleteLikeUseCase
) : ViewModel() {

    fun addLike(id: String) {
        viewModelScope.launch {
            addLikeUseCase(id)
        }
    }

    fun removeLike(id: String) {
        viewModelScope.launch {
            deleteLikeUseCase(id)
        }
    }
}