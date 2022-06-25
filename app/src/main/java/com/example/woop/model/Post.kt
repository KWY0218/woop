package com.example.woop.data.model

data class Post(
    val title: String,
    val content: String,
    val writer: String,
    val tag: Int,
    val comment: List<Comment>
) {
    data class Comment(
        val timestamp: String,
        val content: String,
        val userName: String
    )
}