package com.example.users_app.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.users_app.domain.interfaces.IUserRepository
import com.example.users_app.domain.models.UserModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: IUserRepository
) : ViewModel() {

    private val _users = mutableStateListOf<UserModel>()
    val users: List<UserModel> get() = _users

    fun getAllUsers() {
        try {
            viewModelScope.launch {
                val results = repository.getUsers()
                _users.addAll(results)
            }
        } catch (e: Exception) {
            println(e.toString())
        }
    }
}

class HomeViewModelFactory(
    private val repository: IUserRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return HomeViewModel(
            repository = repository
        ) as T
    }
}