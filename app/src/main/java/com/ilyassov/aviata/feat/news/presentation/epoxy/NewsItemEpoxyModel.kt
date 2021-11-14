package com.ilyassov.aviata.feat.news.presentation.epoxy

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.ilyassov.aviata.R
import com.ilyassov.aviata.databinding.ItemNewsBinding
import com.ilyassov.aviata.extension.formatDateTime
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.util.Utils
import com.ilyassov.aviata.util.common.ui.epoxy.helper.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass
abstract class NewsItemEpoxyModel: ViewBindingEpoxyModelWithHolder<ItemNewsBinding>() {

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var listener: () -> Unit

    @EpoxyAttribute
    lateinit var model: NewsItemView

    override fun ItemNewsBinding.bind() {
        val context = root.context

        if(::listener.isInitialized){
            root.setOnClickListener {
                listener()
            }
        }

        title.text = model.title
        date.text = model.publishedAt.formatDateTime(Utils.serverDateFormat, Utils.dateFormat)
        author.text = model.author
    }

    override fun getDefaultLayout(): Int = R.layout.item_news
}