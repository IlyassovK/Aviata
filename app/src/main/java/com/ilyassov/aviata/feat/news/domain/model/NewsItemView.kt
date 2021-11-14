package com.ilyassov.aviata.feat.news.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ilyassov.aviata.feat.news.data.model.Source

@Entity(tableName = "news")
class NewsItemView(
    @PrimaryKey val id: Int? = null,
    @ColumnInfo val author: String,
    @ColumnInfo val content: String,
    @ColumnInfo val description: String,
    @ColumnInfo val publishedAt: String,
    @ColumnInfo val title: String,
    @ColumnInfo val url: String,
    @ColumnInfo val urlToImage: String
)