package com.uxstate.recipeapp.feature_recipe.data.remote.dto


import com.squareup.moshi.JsonClass
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesList

@JsonClass(generateAdapter = true)
data class RecipesListDTO(
    val count: Int,
    val results: List<RecipeDTO>
)

fun RecipesListDTO.toRecipesList():RecipesList{

    return RecipesList(count = count, results = results)
}