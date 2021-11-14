package com.ilyassov.aviata.database

import androidx.room.Room
import org.koin.dsl.module

val databaseModule = module {
    single { Room.databaseBuilder(get(), NewsDatabase::class.java, "news_db").build() }

    single { get<NewsDatabase>().newsDao()}
}
