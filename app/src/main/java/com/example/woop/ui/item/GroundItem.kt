package com.example.woop.ui.item

import com.example.woop.R
import com.example.woop.databinding.ItemGroundBinding
import com.xwray.groupie.databinding.BindableItem

class GroundItem() : BindableItem<ItemGroundBinding>() {
    override fun bind(viewBinding: ItemGroundBinding, position: Int) {
    }

    override fun getLayout(): Int = R.layout.item_ground
}
