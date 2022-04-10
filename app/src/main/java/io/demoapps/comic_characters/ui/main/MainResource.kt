package io.demoapps.comic_characters.ui.main

import androidx.annotation.Nullable

class MainResource<T>(
    val status: Status,
    val data: T?,
    val message: String?
) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T?): MainResource<T> {
            return MainResource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): MainResource<T> {
            return MainResource(Status.ERROR, data, msg)
        }

        fun <T> loading(@Nullable data: T?): MainResource<T> {
            return MainResource(Status.LOADING, data, null)
        }
    }
}