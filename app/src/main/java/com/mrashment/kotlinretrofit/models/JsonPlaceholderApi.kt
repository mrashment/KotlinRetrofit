package com.mrashment.kotlinretrofit.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonPlaceholderApi {
    @GET("users")
    fun getAllUsers(): Call<List<User>>

    @GET("posts")
    fun getAllPosts(): Call<List<Post>>

    @GET ("posts")
    fun getPosts(
        @Query("userId")userId: Int?,
        @Query("_sort")sort: String?,
        @Query("_order")order: String?
    ): Call<List<Post>>

    @GET("albums")
    fun getAllAlbums(): Call<List<Album>>

    @GET("photos")
    fun getPhotos(
        @Query("albumId")albumId: Int?
    ): Call<List<Photo>>
}