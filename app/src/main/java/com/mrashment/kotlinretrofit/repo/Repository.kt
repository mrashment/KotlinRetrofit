package com.mrashment.kotlinretrofit.repo

import com.mrashment.kotlinretrofit.models.JsonPlaceholderApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KProperty

object Repository {

    val retrofit by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: JsonPlaceholderApi by lazy {
        val jsonPlaceholderApi = (retrofit as Retrofit).create(JsonPlaceholderApi::class.java)
    }


    fun getAllPosts() = service

}


