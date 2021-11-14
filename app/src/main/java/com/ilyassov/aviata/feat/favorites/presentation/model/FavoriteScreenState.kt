package com.ilyassov.aviata.feat.favorites.presentation.model

import com.ilyassov.aviata.feat.news.domain.model.NewsItemView

sealed class FavoriteScreenState{
    object Loading: FavoriteScreenState()
    class ErrorLoaded(val message: String) : FavoriteScreenState()
    class Loaded(val data: List<NewsItemView>): FavoriteScreenState()
}
