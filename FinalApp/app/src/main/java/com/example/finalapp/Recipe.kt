package com.example.finalapp

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("title") val title: String,
    @SerializedName("image") val image: String,
    @SerializedName("summary") val summary: String,
    @SerializedName("extendedIngredients") val extendedIngredients: Array<Ingredient>,
    @SerializedName("servings") val servings: Int,
    val bookmarked: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recipe

        if (bookmarked != other.bookmarked) return false
        if (title != other.title) return false
        if (image != other.image) return false
        if (summary != other.summary) return false
        if (!extendedIngredients.contentEquals(other.extendedIngredients)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = bookmarked.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + image.hashCode()
        result = 31 * result + summary.hashCode()
        result = 31 * result + extendedIngredients.contentHashCode()
        return result
    }
}

data class Ingredient(
    @SerializedName("aisle") val aisle: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("unit") val unit: String,
    @SerializedName("name") val name: String
)
