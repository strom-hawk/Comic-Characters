package io.demoapps.comic_characters.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Posts(
    @Expose
    @SerializedName("id")
    val userId: Int,
)