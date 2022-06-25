package com.example.woop.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.woop.R
import com.example.woop.databinding.ActivityPostDetailBinding

class PostDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_detail)
        val title = intent.getStringExtra("title")
        val tag = intent.getIntExtra("tag", 0)
        val writer = intent.getStringExtra("writer")
        val content = intent.getStringExtra("content")

        binding.detailTitleTv.text = title
        binding.detailWriterTv.text = writer
        binding.detailContentTv.text = content
        when (tag) {
            0 -> {
                binding.detailTag1Cp.text = "음식쉐어"
                binding.detailTag1Cp.background =
                    ContextCompat.getDrawable(this, R.drawable.food_back_selector)
                binding.detailTag1Cp.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.drawable.food_text_selector
                    )
                )
                binding.detailTag1Cp.isSelected = !binding.detailTag1Cp.isSelected
            }
            1 -> {
                binding.detailTag1Cp.text = "요청해요"
                binding.detailTag1Cp.background =
                    ContextCompat.getDrawable(this, R.drawable.request_back_selector)
                binding.detailTag1Cp.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.drawable.request_text_selector
                    )
                )
                binding.detailTag1Cp.isSelected = !binding.detailTag1Cp.isSelected
            }
            2 -> {
                binding.detailTag1Cp.text = "친목해요"
                binding.detailTag1Cp.background =
                    ContextCompat.getDrawable(this, R.drawable.friend_back_selector)
                binding.detailTag1Cp.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.drawable.friend_text_selector
                    )
                )
                binding.detailTag1Cp.isSelected = !binding.detailTag1Cp.isSelected
            }
        }
    }
}
