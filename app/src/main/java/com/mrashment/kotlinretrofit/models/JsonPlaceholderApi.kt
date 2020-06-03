package com.mrashment.kotlinretrofit.models

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("posts")
    fun getAllPosts(): Call<List<Post>>

    @GET("users")
    fun getAllUsers(): Call<List<User>>
}