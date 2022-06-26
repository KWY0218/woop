package com.example.woop.ui.posts

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.woop.R
import com.example.woop.model.Post
import com.example.woop.databinding.PostFrameBinding

class PostsAdapter(private val context: Context, private val onItemClick: (Post) -> Unit) :
    ListAdapter<Post, PostsAdapter.PostViewHolder>(POST_COMPARATOR) {
    class PostViewHolder(
        private val binding: PostFrameBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceType", "SetTextI18n")
        fun bind(post: Post, context: Context, onItemClick: (Post) -> Unit) {
            binding.postRoot.setOnClickListener {
                onItemClick(post)
            }
            binding.postContent.text = post.content
            binding.postTitle.text = post.title
            binding.postWriter.text = "${post.userId.dong}동 ${post.userId.ho}호 ${post.userId.nickName}"
            when (post.tag) {
                1 -> {
                    binding.postTag.text = "음식쉐어"
                    binding.postTag.background =
                        ContextCompat.getDrawable(context, R.drawable.food_back_selector)
                    binding.postTag.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.drawable.food_text_selector
                        )
                    )
                    binding.postTag.isSelected = !binding.postTag.isSelected
                }
                2 -> {
                    binding.postTag.text = "요청해요"
                    binding.postTag.background =
                        ContextCompat.getDrawable(context, R.drawable.request_back_selector)
                    binding.postTag.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.drawable.request_text_selector
                        )
                    )
                    binding.postTag.isSelected = !binding.postTag.isSelected
                }
                3 -> {
                    binding.postTag.text = "친목해요"
                    binding.postTag.background =
                        ContextCompat.getDrawable(context, R.drawable.friend_back_selector)
                    binding.postTag.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.drawable.friend_text_selector
                        )
                    )
                    binding.postTag.isSelected = !binding.postTag.isSelected
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = PostFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, context, onItemClick)
    }

    companion object {
        private val POST_COMPARATOR = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.postId == newItem.postId
            }
        }
    }
}
