package com.example.woop.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.woop.ApiService
import com.example.woop.R
import com.example.woop.databinding.ActivityPostDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostDetailBinding
    private lateinit var commentAdapter: CommentAdapter

    @Inject
    lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_detail)
        val postId = intent.getIntExtra("postId", 1)
        commentAdapter = CommentAdapter()
        binding.detailCommentRv.adapter = commentAdapter
        lifecycleScope.launch {
            runCatching {
                apiService.getPostDetail(postId)
            }
                .onSuccess {
                    binding.detailTitleTv.text = it.response.title
                    binding.detailWriterTv.text =
                        "${it.response.userId.dong}동 ${it.response.userId.ho}호 ${it.response.userId.nickName}"
                    binding.detailContentTv.text = it.response.content
                    when (it.response.tag) {
                        1 -> {
                            binding.detailTag1Cp.text = "음식쉐어"
                            binding.detailTag1Cp.background =
                                ContextCompat.getDrawable(
                                    this@PostDetailActivity,
                                    R.drawable.food_back_selector
                                )
                            binding.detailTag1Cp.setTextColor(
                                ContextCompat.getColor(
                                    this@PostDetailActivity,
                                    R.drawable.food_text_selector
                                )
                            )
                            binding.detailTag1Cp.isSelected = !binding.detailTag1Cp.isSelected
                        }
                        2 -> {
                            binding.detailTag1Cp.text = "요청해요"
                            binding.detailTag1Cp.background =
                                ContextCompat.getDrawable(
                                    this@PostDetailActivity,
                                    R.drawable.request_back_selector
                                )
                            binding.detailTag1Cp.setTextColor(
                                ContextCompat.getColor(
                                    this@PostDetailActivity,
                                    R.drawable.request_text_selector
                                )
                            )
                            binding.detailTag1Cp.isSelected = !binding.detailTag1Cp.isSelected
                        }
                        3 -> {
                            binding.detailTag1Cp.text = "친목해요"
                            binding.detailTag1Cp.background =
                                ContextCompat.getDrawable(
                                    this@PostDetailActivity,
                                    R.drawable.friend_back_selector
                                )
                            binding.detailTag1Cp.setTextColor(
                                ContextCompat.getColor(
                                    this@PostDetailActivity,
                                    R.drawable.friend_text_selector
                                )
                            )
                            binding.detailTag1Cp.isSelected = !binding.detailTag1Cp.isSelected
                        }
                    }
                    commentAdapter.submitList(it.response.commentList)
                }
                .onFailure {
                    Log.d("asdf", "post fail: ${it.message} error: $it vause ${it.suppressed}")
                }
        }
    }
}
