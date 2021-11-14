package com.ilyassov.aviata.feat.news.domain.repository

import androidx.paging.PagingData
import com.ilyassov.aviata.feat.news.data.model.NewsResponseDTO
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.util.common.domain.Result
import kotlinx.coroutines.flow.Flow


interface NewsRepository {
    fun paginateHeadlineNews(): Flow<PagingData<NewsItemView>>

    fun paginateAllNews(): Flow<PagingData<NewsItemView>>

    suspend fun insertFavorite(news: NewsItemView)

    suspend fun deleteFavorite(news: NewsItemView)
}