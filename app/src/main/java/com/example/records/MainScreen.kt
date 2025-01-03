package com.example.records

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(mainView: MainView = hiltViewModel()){
    LaunchedEffect(Unit) {

    }
    Column {
        Text(text = "Insert successful!", style = MaterialTheme.typography.bodyLarge)
    }
}