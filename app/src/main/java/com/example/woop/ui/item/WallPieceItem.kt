package com.example.woop.ui.item

import com.example.woop.R
import com.example.woop.databinding.ItemPieceWallBinding
import com.xwray.groupie.databinding.BindableItem

class WallPieceItem : BindableItem<ItemPieceWallBinding>() {

    override fun getLayout(): Int = R.layout.item_piece_wall

    override fun bind(viewBinding: ItemPieceWallBinding, position: Int) {
    }
}
