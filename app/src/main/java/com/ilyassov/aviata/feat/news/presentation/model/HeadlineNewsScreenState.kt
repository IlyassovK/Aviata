package com.ilyassov.aviata.feat.news.presentation.model

import com.ilyassov.aviata.feat.news.domain.model.NewsItemView

sealed class HeadlineNewsScreenState {
    object Loading : HeadlineNewsScreenState()
    class ErrorLoaded(val message: String): HeadlineNewsScreenState()
}