package com.example.woop.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("postId") val postId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("tag") val tag: Int,
    @SerializedName("userId") val userId: DetailPost,
    @SerializedName("commentList") val commentList: List<Comment>? = null
)

data class DetailPost(
    val userId: Int,
    val dong: String,
    val ho: String,
    val nickName: String,
    val fcmToken: String,
    val roomNumber: Int,
    val floor: Int
)

data class Comment(
    val content: String,
    val userName: String
)
