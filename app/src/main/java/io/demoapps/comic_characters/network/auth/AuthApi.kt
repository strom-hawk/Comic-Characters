package io.demoapps.comic_characters.network.auth

import io.demoapps.comic_characters.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {
    @GET("/users/{id}")
    fun getUser(
        @Path("id") userId: String
    ): Flowable<User>
}