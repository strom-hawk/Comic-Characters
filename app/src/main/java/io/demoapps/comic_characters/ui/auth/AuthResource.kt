package io.demoapps.comic_characters.ui.auth

import androidx.annotation.Nullable

class AuthResource<T>(
    val status: AuthStatus,
    val data: T?,
    val message: String?
) {
    enum class AuthStatus {
        AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED
    }

    companion object {
        fun <T> authenticated(data: T?): AuthResource<T> {
            return AuthResource(AuthStatus.AUTHENTICATED, data, null)
        }

        fun <T> error(msg: String, data: T?): AuthResource<T> {
            return AuthResource(AuthStatus.ERROR, data, msg)
        }

        fun <T> loading(@Nullable data: T?): AuthResource<T> {
            return AuthResource(AuthStatus.LOADING, data, null)
        }

        fun <T> logout(): AuthResource<T> {
            return AuthResource(AuthStatus.NOT_AUTHENTICATED, null, null)
        }
    }
}
