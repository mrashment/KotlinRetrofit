package com.mrashment.kotlinretrofit.repo

import com.mrashment.kotlinretrofit.models.JsonPlaceholderApi
import com.mrashment.kotlinretrofit.models.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KProperty

object Repository {

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/mrashment/my-typicode-server/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val service: JsonPlaceholderApi = retrofit.create(JsonPlaceholderApi::class.java)


    fun getAllPosts() = service.getAllPosts()

    fun getAllAlbums() = service.getAllAlbums()

    fun getPosts(userId: Int?, sort: String?, order: String?) = service.getPosts(userId,sort,order)

    fun getAllUsers() = service.getAllUsers()

    fun getPhotos(albumId: String?) = service.getPhotos(albumId)

    fun getTodos(userId: Int?) = service.getTodos(userId)

    fun postPost(post: Post) = service.postPost(post)

}


