package com.example.users_app.domain.interfaces

import com.example.users_app.domain.models.UserModel

interface IUserRepository {

    suspend fun getUsers(): List<UserModel>

}