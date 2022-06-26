package com.example.woop.ui.posts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.woop.ApiService
import com.example.woop.R
import com.example.woop.databinding.ActivityPostListBinding
import com.example.woop.model.Post
import com.example.woop.ui.detail.PostDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostListBinding
    private lateinit var postsAdapter: PostsAdapter

    @Inject
    lateinit var apiService: ApiService
    private val onItemClick: (Post) -> Unit = { post ->
        val intent = Intent(this, PostDetailActivity::class.java)
        intent.putExtra("postId", post.postId)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_list)
        initAdapter()
        lifecycleScope.launch {
            runCatching {
                delay(500)
                apiService.getPost()
            }
                .onSuccess {
                    Log.d("asdf", "post success: ${it.response}")
                    postsAdapter.submitList(it.response)
                }
                .onFailure {
                    Log.d("asdf", "post fail: ${it.message} error: $it")
                }
        }
    }

    private fun initAdapter() {
        postsAdapter = PostsAdapter(this, onItemClick)
        binding.postsRv.adapter = postsAdapter
    }
}
