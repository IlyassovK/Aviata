package com.ilyassov.aviata.feat.favorites.data.repository

import com.ilyassov.aviata.database.NewsDao
import com.ilyassov.aviata.feat.favorites.domain.repository.FavoritesRepository
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class FavoriteRepositoryImpl(
    private val newsDao: NewsDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): FavoritesRepository {
    override fun getAllFavoritesNews(): Flow<List<NewsItemView>> {
        return newsDao.getAllFavoriteNews()
    }

    override suspend fun deleteFavoriteNews(news: NewsItemView) {
        withContext(ioDispatcher){

        }
    }
}