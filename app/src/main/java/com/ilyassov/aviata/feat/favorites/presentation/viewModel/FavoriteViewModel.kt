package com.ilyassov.aviata.feat.favorites.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyassov.aviata.feat.favorites.domain.repository.FavoritesRepository
import com.ilyassov.aviata.feat.favorites.presentation.model.FavoriteScreenState
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.feat.news.presentation.model.AllNewsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val repository: FavoritesRepository
): ViewModel() {

    private val _state: MutableStateFlow<FavoriteScreenState> =
        MutableStateFlow(FavoriteScreenState.Loading)
    val state: SharedFlow<FavoriteScreenState> = _state

    init {
        getAllFavoritesNews()
    }

    private fun getAllFavoritesNews(){
        viewModelScope.launch {
            repository.getAllFavoritesNews().collect {
                _state.emit(FavoriteScreenState.Loaded(it))
            }
        }
    }

    fun deleteFavoriteNews(){

    }

}