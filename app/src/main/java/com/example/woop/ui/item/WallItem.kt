package com.example.woop.ui.item

import com.example.woop.R
import com.example.woop.databinding.ItemWallBinding
import com.xwray.groupie.databinding.BindableItem

class WallItem : BindableItem<ItemWallBinding>() {
    override fun bind(viewBinding: ItemWallBinding, position: Int) {
    }

    override fun getLayout(): Int = R.layout.item_wall
}
