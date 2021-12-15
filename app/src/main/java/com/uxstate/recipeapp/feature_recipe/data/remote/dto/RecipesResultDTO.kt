package com.uxstate.recipeapp.feature_recipe.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesResult

@JsonClass(generateAdapter = true)
data class RecipesResultDTO(
    val count: Int,
    val results: List<RecipeDTO>
)

fun RecipesResultDTO.toRecipesResult():RecipesResult{

    return RecipesResult(count = count, results = results)
}