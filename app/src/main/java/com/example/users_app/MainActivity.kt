package com.example.users_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.users_app.data.repositories.UserRepository
import com.example.users_app.data.services.UserApiService
import com.example.users_app.ui.theme.DogsAppTheme
import com.example.users_app.ui.viewmodels.HomeViewModel
import com.example.users_app.ui.views.HomeView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)


        setContent {
            DogsAppTheme {
                HomeView(
                    viewModel = HomeViewModel(
                        repository = UserRepository(retrofit)
                    )
                )
            }
        }
    }
}