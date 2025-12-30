package com.bisaai.portfolio.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("userId")
    val userId: Int = 0,

    @SerializedName("title")
    val title: String = "",

    @SerializedName("body")
    val body: String = ""
)

data class User(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("username")
    val username: String = "",

    @SerializedName("email")
    val email: String = ""
)