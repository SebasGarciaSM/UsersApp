package com.example.users_app.data.services

import com.example.users_app.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<UserResponse>>

}