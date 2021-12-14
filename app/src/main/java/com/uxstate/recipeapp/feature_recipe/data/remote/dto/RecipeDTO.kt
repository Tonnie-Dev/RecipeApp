package com.uxstate.recipeapp.feature_recipe.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeDTO(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)