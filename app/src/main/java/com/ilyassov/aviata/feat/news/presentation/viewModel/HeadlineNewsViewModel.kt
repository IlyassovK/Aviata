package com.ilyassov.aviata.feat.news.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.feat.news.domain.repository.NewsRepository
import com.ilyassov.aviata.feat.news.presentation.model.HeadlineNewsScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class HeadlineNewsViewModel(
    private val repository: NewsRepository
): ViewModel() {

    private val _state: MutableStateFlow<HeadlineNewsScreenState> =
        MutableStateFlow(HeadlineNewsScreenState.Loading)
    val state: SharedFlow<HeadlineNewsScreenState> = _state

    fun paginateHeadlineNews(): Flow<PagingData<NewsItemView>> {
        viewModelScope.launch {
            _state.emit(HeadlineNewsScreenState.Loading)
        }
        return repository.paginateHeadlineNews().cachedIn(viewModelScope)
    }

}