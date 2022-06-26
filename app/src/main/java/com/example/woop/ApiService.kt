package com.example.woop

import com.example.woop.request.WriteRequest
import com.example.woop.response.ApartResponse
import com.example.woop.response.PostDetailResponse
import com.example.woop.response.PostResponse
import retrofit2.http.*

// ktlint-disable no-wildcard-imports

interface ApiService {

    @GET("/posts")
    suspend fun getPost(): PostResponse

    @GET("/posts/one")
    suspend fun getPostDetail(
        @Query("postId") postId: Int
    ): PostDetailResponse

    @POST("/posts")
    suspend fun writePost(
        @Body writeRequest: WriteRequest
    )

    @FormUrlEncoded
    @POST("/users/token")
    suspend fun saveToken(
        @Field("token") token: String,
        @Field("user_id") userId: Int
    )

    @GET("/building/plz")
    suspend fun getApart(
        @Query("user_id") userId: Int
    ): ApartResponse

    @FormUrlEncoded
    @POST("/users/qooq")
    suspend fun qooq(
        @Field("dong") dong: Int,
        @Field("ho") ho: Int,
        @Field("user_id") userId: Int
    )
}
