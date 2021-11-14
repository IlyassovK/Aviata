package com.ilyassov.aviata.util.common.ui.epoxy.component

import com.airbnb.epoxy.EpoxyModelClass
import com.ilyassov.aviata.R
import com.ilyassov.aviata.util.common.ui.epoxy.helper.ViewBindingEpoxyModelWithHolder
import com.ilyassov.aviata.databinding.ItemLoadingBinding

@EpoxyModelClass
abstract class LoadingEpoxyModel : ViewBindingEpoxyModelWithHolder<ItemLoadingBinding>() {

    override fun ItemLoadingBinding.bind() {}

    override fun getDefaultLayout(): Int = R.layout.item_loading
}
