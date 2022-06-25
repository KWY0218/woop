package com.example.woop.ui.item

import android.content.Intent
import android.view.View
import com.example.woop.R
import com.example.woop.databinding.ItemWallBinding
import com.example.woop.model.MainGlass
import com.example.woop.ui.GlassActivity
import com.xwray.groupie.databinding.BindableItem

class WallItem(val mainGlass: MainGlass = MainGlass()) : BindableItem<ItemWallBinding>() {
    override fun bind(binding: ItemWallBinding, position: Int) {
        binding.ivHuman.visibility = if (mainGlass.isMe) View.VISIBLE else View.GONE
        binding.ivExclamationmark.visibility = if (mainGlass.isOnBoard) View.VISIBLE else View.GONE
        binding.ivGlass.background =
            if (mainGlass.isOnBoard or mainGlass.isMe) binding.root.resources.getDrawable(R.drawable.rectangle_on) else binding.root.resources.getDrawable(
                R.drawable.rectangle_off
            )
        binding.root.setOnClickListener {
            binding.root.context.startActivity(
                Intent(
                    binding.root.context,
                    GlassActivity::class.java
                )
            )
        }
    }

    override fun getLayout(): Int = R.layout.item_wall
}
