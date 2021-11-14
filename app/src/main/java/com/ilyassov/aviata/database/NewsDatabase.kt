package com.ilyassov.aviata.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView

@Database(entities = [NewsItemView::class],version = 1)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDao
}