package com.example.woop

import com.example.woop.request.WriteRequest
import com.example.woop.response.ApartResponse
import com.example.woop.response.PostDetailResponse
import com.example.woop.response.PostResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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

    @GET("/building/floor?user_id=1&floor_num=7")
    suspend fun buildWindow(
        @Query("user_id") userId: Int,
        @Query("floor_num") floorNum: Int,
    ): List<List<Boolean>>

    @GET("/building/overall")
    suspend fun getApart(
        @Query("user_id") userId: Int
    ): ApartResponse
}
