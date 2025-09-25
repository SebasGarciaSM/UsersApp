package com.example.users_app.data.repositories

import com.example.users_app.data.services.UserApiService
import com.example.users_app.domain.interfaces.IUserRepository
import com.example.users_app.domain.models.AddressModel
import com.example.users_app.domain.models.UserModel

class UserRepository(
    private val api: UserApiService
) : IUserRepository {

    override suspend fun getUsers(): List<UserModel> {
        return try {
            val listOfUsers = mutableListOf<UserModel>()
            val response = api.getUsers()

            if (response.isSuccessful) {
                val users = response.body()


                if (users != null) {
                    for (user in users) {
                        listOfUsers.add(
                            UserModel(
                                id = user.id,
                                name = user.name,
                                username = user.username,
                                email = user.email,
                                address = AddressModel(
                                    street = user.address.street,
                                    suite = user.address.suite,
                                    city = user.address.city,
                                    zipcode = user.address.zipcode,
                                )
                            )
                        )
                    }
                }
            }

            listOfUsers

        } catch (e: Exception) {
            println(e.toString())
            emptyList<UserModel>()
        }
    }
}
