package com.ilyassov.aviata.util.common.ui.epoxy.component

import com.airbnb.epoxy.EpoxyModelClass
import com.ilyassov.aviata.R
import com.ilyassov.aviata.databinding.ItemEmptyBinding
import com.ilyassov.aviata.util.common.ui.epoxy.helper.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass
abstract class EmptyListEpoxyModel :
    ViewBindingEpoxyModelWithHolder<ItemEmptyBinding>() {

    override fun ItemEmptyBinding.bind() {}

    override fun getDefaultLayout(): Int = R.layout.item_empty
}
