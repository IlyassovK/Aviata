package com.ilyassov.aviata.di

import com.google.gson.GsonBuilder
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.ilyassov.aviata.util.Utils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit()}
}


val logging = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}

val httpClient = OkHttpClient.Builder().apply {
    addInterceptor(logging)
    addInterceptor(Interceptor { chain ->
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("apiKey", Utils.API_KEY)
            .build()

        val requestBuilder = original.newBuilder().url(url)

        val request = requestBuilder.build()

        chain.proceed(request)
    })
}

private fun provideRetrofit(): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://newsapi.org")
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        )
        .client(httpClient.build())
        .build()