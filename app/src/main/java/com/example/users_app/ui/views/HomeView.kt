package com.example.users_app.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.users_app.ui.viewmodels.HomeViewModel

@Composable
fun HomeView(
    viewModel: HomeViewModel
) {

    LaunchedEffect(Unit) {
        viewModel.getAllUsers()
    }

    val users = remember { viewModel.users }

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(users) { user ->
                Card(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                    ) {
                        Text(user.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(user.username)
                        Text(user.email)
                        Spacer(Modifier.height(4.dp))
                        Text("Address", fontWeight = FontWeight.Bold)
                        Text(user.address.street)
                        Text(user.address.suite)
                        Text(user.address.city)
                        Text(user.address.zipcode)
                    }

                }
            }
        }
    }
}