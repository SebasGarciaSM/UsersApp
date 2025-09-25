package com.example.users_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.users_app.data.repositories.UserRepository
import com.example.users_app.data.services.UserApiService
import com.example.users_app.ui.theme.UsersAppTheme
import com.example.users_app.ui.viewmodels.HomeViewModel
import com.example.users_app.ui.viewmodels.HomeViewModelFactory
import com.example.users_app.ui.views.HomeView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UsersAppTheme {
                HomeView()
            }
        }
    }

}