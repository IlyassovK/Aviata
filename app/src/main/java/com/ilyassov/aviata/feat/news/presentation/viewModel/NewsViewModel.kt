package com.ilyassov.aviata.feat.news.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.feat.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repository: NewsRepository
): ViewModel() {

    private val _selectedNews: MutableStateFlow<NewsItemView?> =
        MutableStateFlow(null)
    val selectedNews: SharedFlow<NewsItemView?> = _selectedNews

    fun selectNews(news: NewsItemView){
        viewModelScope.launch {
            _selectedNews.emit(news)
        }
    }

    fun insertFavorite(news: NewsItemView){
        viewModelScope.launch {
            repository.insertFavorite(news)
        }
    }

    fun deleteFavorite(news: NewsItemView){
        viewModelScope.launch {
            repository.deleteFavorite(news)
        }
    }

}