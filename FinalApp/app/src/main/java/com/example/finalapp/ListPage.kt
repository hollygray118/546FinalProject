package com.example.finalapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue

@Composable
fun ListPage(viewModel: RecipeViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .height(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "List Screen",
            color = Color.White,
        )
    }
    if(savedRecipes.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Spacer(Modifier.size(40.dp))
            Text(
                "You do not have any recipes bookmarked so your grocery list is empty.",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
    else {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Spacer(Modifier.size(40.dp))
        }
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            LazyColumn {
                items(savedRecipes) { recipe ->
                    IngredientList(recipe.extendedIngredients.toList())
                }
            }
        }
    }
}

@Composable
fun DisplayIngredient(ingredient: Ingredient) {
    var checked by remember { mutableStateOf(false) }
    Column(
        //verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Text(ingredient.name)
            Text(ingredient.amount.toString() + " " + ingredient.unit)
        }
    }
}

@Composable
fun IngredientList(ingredientList: List<Ingredient>) {
    LazyColumn(modifier = Modifier.height(100.dp)) {
        items(ingredientList) { ingredient ->
            DisplayIngredient(ingredient)
        }
    }
}
