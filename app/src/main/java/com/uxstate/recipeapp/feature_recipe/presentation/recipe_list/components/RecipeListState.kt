package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe

data class RecipeListState(
    val loading: Boolean = false,
    val error: String = "",
    val recipes: List<Recipe> = emptyList()
) {
}