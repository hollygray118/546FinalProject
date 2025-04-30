package com.example.finalapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val _results = MutableStateFlow<Array<Recipe?>>(emptyArray())
    val results: StateFlow<Array<Recipe?>> = _results

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchSearchResults()
    }
    private fun fetchSearchResults() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val response = RetrofitInstance2.search_api.getSearchResults()
                _results.value = response.results
            } catch (e: Exception) {
                _error.value = "Failed to load recipe: ${e.message}"
            }
            _loading.value = false
        }
    }
}