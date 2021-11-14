package com.ilyassov.aviata.feat.news.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ilyassov.aviata.database.NewsDao
import com.ilyassov.aviata.feat.news.data.paging.AllNewsPagingSource
import com.ilyassov.aviata.feat.news.data.paging.HeadlineNewsPagingSource
import com.ilyassov.aviata.feat.news.data.service.NewsService
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.feat.news.domain.repository.NewsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class NewsRepositoryImpl(
    private val newsService: NewsService,
    private val newsDao: NewsDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): NewsRepository {

    override fun paginateHeadlineNews(): Flow<PagingData<NewsItemView>> {
        return Pager(
            config = PagingConfig(
                pageSize = HeadlineNewsPagingSource.PAGE_SIZE,
                initialLoadSize = HeadlineNewsPagingSource.INITIAL_LOAD_SIZE
            ),
            pagingSourceFactory = {
                HeadlineNewsPagingSource(
                    service = newsService
                )
            }
        ).flow
    }

    override fun paginateAllNews(): Flow<PagingData<NewsItemView>> {
        return Pager(
            config = PagingConfig(
                pageSize = AllNewsPagingSource.PAGE_SIZE,
                initialLoadSize = AllNewsPagingSource.INITIAL_LOAD_SIZE
            ),
            pagingSourceFactory = {
                AllNewsPagingSource(
                    service = newsService
                )
            }
        ).flow
    }

    override suspend fun insertFavorite(news: NewsItemView) {
        withContext(ioDispatcher){
            newsDao.insertFavoriteNews(news)
        }
    }

    override suspend fun deleteFavorite(news: NewsItemView) {
        withContext(ioDispatcher){
            newsDao.deleteFavoriteNews(news)
        }
    }
}