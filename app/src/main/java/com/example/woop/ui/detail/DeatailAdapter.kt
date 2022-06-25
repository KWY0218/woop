package com.example.woop.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.woop.data.model.Post
import com.example.woop.databinding.CommentFrameBinding

class CommentAdapter :
    ListAdapter<Post.Comment, CommentAdapter.CommentViewHolder>(CommentAdapter.COMMENT_COMPARATOR) {

    class CommentViewHolder(
        private val binding: CommentFrameBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: Post.Comment) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = CommentFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    companion object {
        private val COMMENT_COMPARATOR = object : DiffUtil.ItemCallback<Post.Comment>() {
            override fun areItemsTheSame(oldItem: Post.Comment, newItem: Post.Comment): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Post.Comment, newItem: Post.Comment): Boolean {
                return oldItem.userName == newItem.userName
            }
        }
    }
}
