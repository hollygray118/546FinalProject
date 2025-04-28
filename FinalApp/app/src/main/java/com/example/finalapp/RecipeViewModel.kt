package com.example.finalapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {
    private val _recipe = MutableStateFlow<Recipe?>(null)
    val recipe: StateFlow<Recipe?> = _recipe

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchRandomRecipe()
    }

    private fun fetchRandomRecipe() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val response = RetrofitInstance.api.getRandomRecipe()
                _recipe.value = response.recipes[0]
            } catch (e: Exception) {
                _error.value = "Failed to load recipe: ${e.message}"
            }
            _loading.value = false
        }
    }

}








