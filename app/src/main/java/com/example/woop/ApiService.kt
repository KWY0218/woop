package com.example.woop

import com.example.woop.response.PostDetailResponse
import com.example.woop.response.PostResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/posts")
    suspend fun getPost(): PostResponse

    @GET("/posts/one")
    suspend fun getPostDetail(
        @Query("postId") postId: Int
    ): PostDetailResponse
}
