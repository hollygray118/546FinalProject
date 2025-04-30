package com.example.finalapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SearchPage(viewModel: SearchViewModel = viewModel()) {
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .height(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Search Screen",
            color = Color.White,
        )
    }
    var search by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.padding(top = 60.dp, start = 15.dp, end = 15.dp).fillMaxWidth(),
        value = search,
        onValueChange = { search = it },
        label = { Text("Search") }
    )
    if(search.contains("\n"))
    {
        val results by viewModel.results.collectAsState()
        if(results.isNotEmpty()) {
            PrintSearchResults(search, results)
        } else {
            DisplayNoRecipesFound()
        }
    }
//    var show = false
//    Box(modifier = Modifier.padding(top = 60.dp, start = 15.dp, end = 15.dp).fillMaxWidth()) {
//        ElevatedButton(onClick = {show = true}) { Text("Italian Cuisine", color = Color.DarkGray)}
//        val results by viewModel.results.collectAsState()
//        if (show) {
//            PrintSearchResults(search, results)
//        }
//    }
}

@Composable
fun PrintSearchResults(search: String, results: Array<Recipe?>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp).padding(top = 120.dp).padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        for(i in 0..results.size)
        {
            item {
                DisplayUnbookMarkedRecipe(results[i]!!)
            }
        }
    }
}

@Composable
fun DisplayNoRecipesFound() {
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(Modifier.size(40.dp))
        Text(
            "No recipes matching that search found.",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}