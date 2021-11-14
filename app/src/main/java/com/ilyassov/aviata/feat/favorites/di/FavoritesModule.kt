package com.ilyassov.aviata.feat.favorites.di

import com.ilyassov.aviata.feat.favorites.data.repository.FavoriteRepositoryImpl
import com.ilyassov.aviata.feat.favorites.domain.repository.FavoritesRepository
import com.ilyassov.aviata.feat.favorites.presentation.viewModel.FavoriteViewModel
import com.ilyassov.aviata.feat.news.data.repository.NewsRepositoryImpl
import com.ilyassov.aviata.feat.news.data.service.NewsService
import com.ilyassov.aviata.feat.news.domain.repository.NewsRepository
import com.ilyassov.aviata.feat.news.presentation.viewModel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val favoriteModule = module {
    viewModel { FavoriteViewModel(repository = get()) }
    single<FavoritesRepository> { FavoriteRepositoryImpl(newsDao = get()) }
}