package com.example.records

@Composable
fun SubTableScreen(subTableViewModel: SubTableViewModel = hiltViewModel()) {
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
