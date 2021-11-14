package com.ilyassov.aviata.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    fun getAllFavoriteNews(): Flow<List<NewsItemView>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteNews(news: NewsItemView)

    @Delete
    suspend fun deleteFavoriteNews(news: NewsItemView)
}