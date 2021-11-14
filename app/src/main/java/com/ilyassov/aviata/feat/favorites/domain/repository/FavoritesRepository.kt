package com.ilyassov.aviata.feat.favorites.domain.repository

import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    fun getAllFavoritesNews(): Flow<List<NewsItemView>>

    suspend fun deleteFavoriteNews(news: NewsItemView)
}