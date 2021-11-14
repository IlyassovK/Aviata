package com.ilyassov.aviata.feat.news.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.feat.news.domain.repository.NewsRepository
import com.ilyassov.aviata.feat.news.presentation.model.AllNewsScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class AllNewsViewModel(
    private val repository: NewsRepository
): ViewModel() {

    private val _state: MutableStateFlow<AllNewsScreenState> =
        MutableStateFlow(AllNewsScreenState.Loading)
    val state: SharedFlow<AllNewsScreenState> = _state

    fun paginateAllNews(): Flow<PagingData<NewsItemView>> {
        viewModelScope.launch {
            _state.emit(AllNewsScreenState.Loading)
        }
        return repository.paginateAllNews().cachedIn(viewModelScope)
    }
}