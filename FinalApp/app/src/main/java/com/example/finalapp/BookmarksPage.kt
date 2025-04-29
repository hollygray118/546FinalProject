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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun BookmarksPage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .height(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bookmarks Screen",
            color = Color.White,
        )
    }
    if(savedRecipes.isNotEmpty())
    {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp).padding(top = 40.dp).padding(bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            for(i in 0..<savedRecipes.size)
            {
                item {
                    DisplayBookmarkedRecipe(savedRecipes[i])
                }
            }
        }
    }
    else {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Spacer(Modifier.size(40.dp))
            Text(
                "You do not have any recipes bookmarked so your bookmarks are empty.",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}















