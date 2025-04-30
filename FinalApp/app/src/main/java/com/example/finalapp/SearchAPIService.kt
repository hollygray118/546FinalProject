package com.example.finalapp

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SearchAPIService {
    @GET("/recipes/complexSearch?number=20&apiKey=0da4bd39e94148f5a75127289fb5cc64&cuisine=italian")
    suspend fun getSearchResults(): SearchResults
}

data class SearchResults(@SerializedName("results") val results: Array<Recipe?>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SearchResults

        return results.contentEquals(other.results)
    }

    override fun hashCode(): Int {
        return results.contentHashCode()
    }
}

object RetrofitInstance2 {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.spoonacular.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val search_api: SearchAPIService by lazy { retrofit.create(SearchAPIService::class.java) }
}