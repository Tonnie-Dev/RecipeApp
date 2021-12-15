package com.uxstate.recipeapp.feature_recipe.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipesResultDTO(
    val count: Int,
    val results: List<RecipeDTO>
)