package com.ilyassov.aviata.feat.news.presentation.epoxy

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging3.PagingDataEpoxyController
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.util.common.ui.epoxy.component.LoadingEpoxyModel_
import com.ilyassov.aviata.util.common.ui.epoxy.component.MessageErrorEpoxyModel
import com.ilyassov.aviata.util.common.ui.epoxy.component.MessageErrorEpoxyModel_
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
class NewsEpoxyController (
    private val navigateToDetail: (item: NewsItemView) -> Unit
): PagingDataEpoxyController<NewsItemView>(){

    private var isError: Boolean = false

    var error: String? = ""
        set(value) {
            field = value?.let {
                isError = true
                it
            } ?: kotlin.run {
                isError = false
                null
            }
            if (isError){
                requestModelBuild()
            }
        }

    var isLoading = false
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }

    override fun buildItemModel(currentPosition: Int, item: NewsItemView?): EpoxyModel<*> {
        item?.let {
           return NewsItemEpoxyModel_()
                .id(item.title)
                .model(item)
                .listener{
                    navigateToDetail(item)
                }
        } ?: run {
            return LoadingEpoxyModel_().id("loading")
        }
    }

    override fun addModels(models: List<EpoxyModel<*>>) {
        when{
            isError -> {
                super.addModels(
                    models.plus(
                        MessageErrorEpoxyModel_()
                            .id("Error")
                            .messageText(error ?: "")
                    ).filter {
                        it !is LoadingEpoxyModel_
                    }
                )
            }
            isLoading -> {
                super.addModels(
                    models.plus(
                        LoadingEpoxyModel_()
                            .id("loading")
                    ).distinct()
                )
            }
            else -> {
                super.addModels(models.distinct())
            }
        }
    }

}
