package com.mrashment.kotlinretrofit.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("albums/{albumId}/photos")
    fun getPhotos(
        @Path("albumId")albumId: String?
    ): Call<List<Photo>>

    @GET("todos")
    fun getTodos(
        @Query("userId")userId: Int?
    ): Call<List<Todo>>
}