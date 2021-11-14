package com.ilyassov.aviata.util.common.ui.epoxy.component

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.ilyassov.aviata.R
import com.ilyassov.aviata.databinding.ItemSimpleErrorMessageBinding
import com.ilyassov.aviata.util.common.ui.epoxy.helper.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass
abstract class MessageErrorEpoxyModel :
    ViewBindingEpoxyModelWithHolder<ItemSimpleErrorMessageBinding>() {

    @EpoxyAttribute
    var messageText: String = ""

    override fun ItemSimpleErrorMessageBinding.bind() {
        message.text = messageText
    }

    override fun getDefaultLayout(): Int = R.layout.item_simple_error_message
}
