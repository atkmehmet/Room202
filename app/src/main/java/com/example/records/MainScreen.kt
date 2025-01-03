package com.example.records

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(mainView: MainView = hiltViewModel()){
    val masters by mainView.masters.collectAsState()

    LazyColumn {
        items(masters.size) { it ->
            Text("${masters[it].name}: ${masters[it].text}")
        }
    }
}