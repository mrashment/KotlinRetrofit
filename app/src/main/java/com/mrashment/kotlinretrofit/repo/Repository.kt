package com.mrashment.kotlinretrofit.repo

import com.mrashment.kotlinretrofit.models.JsonPlaceholderApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KProperty

object Repository {

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val service: JsonPlaceholderApi = retrofit.create(JsonPlaceholderApi::class.java)


    fun getAllPosts() = service.getAllPosts()

    fun getAllUser() = service.getAllUsers()

}


