package com.ilyassov.aviata

import android.app.Application
import com.ilyassov.aviata.database.databaseModule
import com.ilyassov.aviata.di.networkModule
import com.ilyassov.aviata.feat.favorites.di.favoriteModule
import com.ilyassov.aviata.feat.news.di.newsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        initLogger()
    }

    private fun initKoin(){
        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                newsModule,
                databaseModule,
                favoriteModule
            )
        }
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}