package com.ilyassov.aviata.feat.news.data.service

import com.haroldadmin.cnradapter.NetworkResponse
import com.ilyassov.aviata.feat.news.data.model.NewsResponseDTO
import com.ilyassov.aviata.util.Utils
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/v2/everything")
    suspend fun getAllNews(
        @Query("q") query: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
        ): NetworkResponse<NewsResponseDTO, Error>

    @GET("/v2/top-headlines")
    suspend fun getHeadlineNews(
        @Query("country") country: String = "us",
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
    ): NetworkResponse<NewsResponseDTO, Error>
}