package com.mrashment.kotlinretrofit.models

data class Post(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)

data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)

data class Geo(val lat: Double,val lng: Double)

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

data class Album(
    val userId: Int,
    val id: Int,
    val title: String
)

data class Photo(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)






















