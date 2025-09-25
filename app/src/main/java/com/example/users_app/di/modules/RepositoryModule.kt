package com.example.users_app.di.modules

import com.example.users_app.data.repositories.UserRepository
import com.example.users_app.domain.interfaces.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepository: UserRepository): IUserRepository

}