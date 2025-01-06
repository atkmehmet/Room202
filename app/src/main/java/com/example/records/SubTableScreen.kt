package com.example.records

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SubTableScreen(subTableViewModel: SubTableView = hiltViewModel()) {
    val subTables by subTableViewModel.subTables.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Master ID Input
        OutlinedTextField(
            value = subTableViewModel.masterId,
            onValueChange = { subTableViewModel.updateMasterId(it) },
            label = { Text("Master ID") },
            modifier = Modifier.fillMaxWidth()
        )

        // Text Input
        OutlinedTextField(
            value = subTableViewModel.text,
            onValueChange = { subTableViewModel.updateText(it) },
            label = { Text("Text") },
            modifier = Modifier.fillMaxWidth()
        )

        // Save Button
        Button(
            onClick = {
                subTableViewModel.insertSubTable()
                Toast.makeText(context, "SubTable entry saved!", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display SubTable List
        LazyColumn {
            items(subTables) { subTable ->
                Text("ID: ${subTable.id}, Master ID: ${subTable.masterId}, Text: ${subTable.text}")
                Divider()
            }
        }
    }
}
