package com.example.finalapp

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface RecipeAPIService {
    @GET("/recipes/random?number=4&apiKey=0da4bd39e94148f5a75127289fb5cc64")
    suspend fun getRandomRecipe(): RandomRecipeResponse
}

data class RandomRecipeResponse(@SerializedName("recipes") val recipes: Array<Recipe>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RandomRecipeResponse

        return recipes.contentEquals(other.recipes)
    }

    override fun hashCode(): Int {
        return recipes.contentHashCode()
    }
}

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.spoonacular.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: RecipeAPIService by lazy { retrofit.create(RecipeAPIService::class.java) }
}