package com.example.woop.response

import com.example.woop.model.Post

data class PostResponse(
    val success: Boolean,
    val response: List<Post>
)

data class PostDetailResponse(
    val success: Boolean,
    val response: Post,
)
