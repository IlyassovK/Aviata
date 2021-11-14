package com.ilyassov.aviata.feat.news.di

import com.ilyassov.aviata.feat.news.data.repository.NewsRepositoryImpl
import com.ilyassov.aviata.feat.news.data.service.NewsService
import com.ilyassov.aviata.feat.news.domain.repository.NewsRepository
import com.ilyassov.aviata.feat.news.presentation.viewModel.AllNewsViewModel
import com.ilyassov.aviata.feat.news.presentation.viewModel.HeadlineNewsViewModel
import com.ilyassov.aviata.feat.news.presentation.viewModel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val newsModule = module {
    viewModel { HeadlineNewsViewModel( repository = get()) }
    viewModel { AllNewsViewModel(repository = get()) }
    viewModel { NewsViewModel(repository = get()) }
    single<NewsRepository> { NewsRepositoryImpl(newsService = get(), newsDao = get()) }
    single { get<Retrofit>().create(NewsService::class.java) }
}