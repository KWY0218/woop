package com.example.woop.ui.item

import com.example.woop.R
import com.example.woop.databinding.ItemTopBinding
import com.xwray.groupie.databinding.BindableItem

class TopItem : BindableItem<ItemTopBinding>() {
    override fun bind(viewBinding: ItemTopBinding, position: Int) {
    }

    override fun getLayout(): Int = R.layout.item_top
}
