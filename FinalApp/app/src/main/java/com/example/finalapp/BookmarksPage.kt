package com.example.finalapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
    if(savedRecipes.isNotEmpty())
    {
        val recipe = savedRecipes[0]
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = recipe.image,
                contentDescription = "Recipe Image",
                )
            Text(
                text = recipe.title,
                fontSize = 16.sp,
                color = Color.DarkGray
            )
            Button(onClick = { whenUnBookmarkButtonClicked(recipe) }) { Text("UnBookmark Recipe")}
            Spacer(modifier = Modifier.height(16.dp))
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

fun whenUnBookmarkButtonClicked(r: Recipe) {
    unBookmarkRecipe(r)
}















