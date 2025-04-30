package com.example.finalapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import kotlin.system.exitProcess

private val numRecipes = 9

@Composable
fun HomePage(viewModel: RecipeViewModel = viewModel()) {
    val recipe by viewModel.recipes.collectAsState()
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
            text = "Home Screen",
            color = Color.White,
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp).padding(top = 60.dp).padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        for(i in 0..numRecipes)
        {
            if(recipe.isNotEmpty()) {
                item {
                    DisplayUnbookMarkedRecipe(recipe[i]!!)
                }
            }
        }
    }
}

@Composable
public fun DisplayUnbookMarkedRecipe(recipe: Recipe) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(Color.LightGray)
    ) {
        AsyncImage(
            model = recipe.image,
            contentDescription = "Recipe Image",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(10.dp)
                .border(2.dp, Color.DarkGray, RectangleShape)
        )
        Box(
            modifier = Modifier
                .size(180.dp)
        ) {
            Text(
                text = recipe.title,
                fontSize = 16.sp,
                color = Color.Black,
                style = TextStyle.Default.copy(lineBreak = LineBreak.Heading),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp)
                    .padding(end = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 10.dp)
                .padding(vertical = 45.dp)
                .height(30.dp)
        ) {
            var display = false
//            ElevatedButton(onClick = { display = true}) { Text("View Ingredients", fontSize = 12.sp, color = Color.DarkGray)}
//            while(display) {
//                IngredientList(recipe.extendedIngredients.toList())
//                display = false
//            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
                .height(30.dp)
        ) {
            ElevatedButton(onClick = { bookmarkRecipe(recipe)}) { Text("Bookmark Recipe", fontSize = 12.sp, color = Color.DarkGray)}
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
public fun DisplayBookmarkedRecipe(recipe: Recipe) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(Color.LightGray)
    ) {
        AsyncImage(
            model = recipe.image,
            contentDescription = "Recipe Image",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(10.dp)
                .border(2.dp, Color.DarkGray, RectangleShape)
        )
        Box(
            modifier = Modifier
                .size(180.dp)
        ) {
            Text(
                text = recipe.title,
                fontSize = 16.sp,
                color = Color.Black,
                style = TextStyle.Default.copy(lineBreak = LineBreak.Heading),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp)
                    .padding(end = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 10.dp)
                .padding(vertical = 45.dp)
                .height(30.dp)
        ) {
            var display = false
//            ElevatedButton(onClick = { display = true}) { Text("View Ingredients", fontSize = 12.sp, color = Color.DarkGray)}
//            if(display) {
//                Column() {
//                    IngredientList(recipe.extendedIngredients.toList())
//                }
//                display = false
//            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
                .height(30.dp)
        ) {
            ElevatedButton(onClick = { unBookmarkRecipe(recipe)}) { Text("Remove Recipe", fontSize = 12.sp, color = Color.DarkGray)}
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
    Spacer(modifier = Modifier.height(16.dp))
}
