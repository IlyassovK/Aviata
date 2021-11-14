package com.ilyassov.aviata.feat.news.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.haroldadmin.cnradapter.NetworkResponse
import com.ilyassov.aviata.feat.news.data.model.NewsResponseDTO
import com.ilyassov.aviata.feat.news.data.service.NewsService
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.util.common.domain.ClientException


class AllNewsPagingSource(
    private val service: NewsService,
) : PagingSource<Int, NewsItemView>() {

    override fun getRefreshKey(state: PagingState<Int, NewsItemView>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsItemView> {
        val page = params.key ?: FIRST_PAGE_INDEX
        val pageSize = params.loadSize

        /*
            По заданию требовалась выбрать одну тему и делать по ней запросы
            Поэтому тут захордкодил запрос на слово apple
         */

        when (
            val response = service.getAllNews(
                query = "apple",
                page = page,
                pageSize = pageSize
            )
        ) {
            is NetworkResponse.Success -> {
                if (response.body.articles.isEmpty()) {
                    return LoadResult.Page(
                        data = response.body.articles.map {
                            NewsItemView(
                                author = it.author ?: "",
                                content = it.content ?: "",
                                description = it.description ?: "",
                                publishedAt = it.publishedAt ?: "",
                                title = it.title ?: "",
                                url = it.url ?: "",
                                urlToImage = it.urlToImage ?: ""
                            )
                        },
                        prevKey = null,
                        nextKey = null
                    )
                }
                return LoadResult.Page(
                    data = response.body.articles.map {
                        NewsItemView(
                            author = it.author ?: "",
                            content = it.content ?: "",
                            description = it.description ?: "",
                            publishedAt = it.publishedAt ?: "",
                            title = it.title ?: "",
                            url = it.url ?: "",
                            urlToImage = it.urlToImage ?: ""
                        )
                    },
                    prevKey = if(page == FIRST_PAGE_INDEX) null else page - 1,
                    nextKey = page + 1
                )
            }
            else -> {
                return LoadResult.Error(
                    Exception("Error")
                )
            }
        }
    }
    companion object {
        const val PAGE_SIZE = 15
        const val INITIAL_LOAD_SIZE = 20
        const val FIRST_PAGE_INDEX = 1
    }
}