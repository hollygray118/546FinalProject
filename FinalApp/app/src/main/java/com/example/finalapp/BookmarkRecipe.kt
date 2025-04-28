package com.example.finalapp

public var savedRecipes = ArrayList<Recipe>()

fun bookmarkRecipe(r: Recipe) {
    if(!savedRecipes.contains(r)) {
        savedRecipes.add(r)
    }
}

fun unBookmarkRecipe(r: Recipe) {
    if(savedRecipes.contains(r)) {
        savedRecipes.remove(r)
    }
}