package com.bisaai.portfolio.service

import com.bisaai.portfolio.model.Post
import com.bisaai.portfolio.model.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Response<Post>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): Response<User>
}

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}