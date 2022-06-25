package com.example.woop.ui.item

import android.view.View
import android.widget.Toast
import com.example.woop.R
import com.example.woop.databinding.ItemExpandGlassBinding
import com.xwray.groupie.databinding.BindableItem

class GlassExpandItem(
    val isExit: Boolean = true,
    val isMine: Boolean = false,
    val isAlert: Boolean = false,
    val roomNumber: String,
    val isClick: Boolean = false
) : BindableItem<ItemExpandGlassBinding>() {

    var isClicked = false
    override fun getLayout(): Int = R.layout.item_expand_glass

    override fun bind(binding: ItemExpandGlassBinding, position: Int) {
        binding.tvHomeNumber.text = roomNumber
        binding.ivExpandGlass.background =
            if (isExit) binding.root.resources.getDrawable(R.drawable.rectangle_expand_on) else binding.root.resources.getDrawable(
                R.drawable.rectangle_expand_off
            )
        binding.ivNotice.visibility = if (isAlert) View.VISIBLE else View.GONE
        binding.ivBigHuman.visibility = if (isMine) View.VISIBLE else View.GONE

        if (isExit) {
            binding.ivExpandGlass.setOnClickListener {
                isClicked = !isClicked
                binding.ivExpandGlass.background = if (isClicked)
                    binding.root.resources.getDrawable(R.drawable.glass_click) else binding.root.resources.getDrawable(
                    R.drawable.rectangle_expand_on
                )
            }
        } else {
            Toast.makeText(binding.root.context, "공실입니다", Toast.LENGTH_SHORT).show()
        }
    }
}
