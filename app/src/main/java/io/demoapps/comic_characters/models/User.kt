package io.demoapps.comic_characters.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("id")
    val userId: Int,

    @Expose
    @SerializedName("name")
    val userName: String,

    @Expose
    @SerializedName("email")
    val userEmail: String,

    @Expose
    @SerializedName("website")
    val userWebSite: String
)