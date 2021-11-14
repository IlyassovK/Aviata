package com.ilyassov.aviata.feat.news.presentation.model

import com.ilyassov.aviata.feat.news.domain.model.NewsItemView

sealed class AllNewsScreenState {
    object Loading : AllNewsScreenState()
    class ErrorLoaded(val message: String): AllNewsScreenState()
}