package com.example.woop.ui.item

import com.example.woop.R
import com.example.woop.databinding.ItemPieceWallLeftBinding
import com.xwray.groupie.databinding.BindableItem

class WallPieceLeftItem : BindableItem<ItemPieceWallLeftBinding>() {

    override fun getLayout(): Int = R.layout.item_piece_wall_left
    override fun bind(viewBinding: ItemPieceWallLeftBinding, position: Int) {}

}
