package com.example.woop.ui.posts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.woop.R
import com.example.woop.data.model.Post
import com.example.woop.databinding.ActivityPostListBinding
import com.example.woop.ui.detail.PostDetailActivity

class PostListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostListBinding
    private lateinit var postsAdapter: PostsAdapter
    private val onItemClick: (Post) -> Unit = { post ->
        val intent = Intent(this, PostDetailActivity::class.java)
        intent.putExtra("title", post.title)
        intent.putExtra("tag", post.tag)
        intent.putExtra("writer", post.writer)
        intent.putExtra("content", post.content)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_list)
        initAdapter()
    }

    private fun initAdapter() {
        postsAdapter = PostsAdapter(this, onItemClick)
        binding.postsRv.adapter = postsAdapter
        postsAdapter.submitList(testList)
    }

    companion object {
        val testList = mutableListOf<Post>(
            Post(
                title = "타이틀 입니다.",
                content = "내용 입니다.",
                writer = "작사가 입니다.",
                tag = 0,
                comment = emptyList(),
            ),
            Post(
                title = "타이틀 입니다.",
                content = "내용 입니다.",
                writer = "작사가 입니다.",
                tag = 1,
                comment = emptyList(),
            ),
            Post(
                title = "타이틀 입니다.",
                content = "내용 입니다.",
                writer = "작사가 입니다.",
                tag = 2,
                comment = emptyList(),
            ),
        )
    }
}
