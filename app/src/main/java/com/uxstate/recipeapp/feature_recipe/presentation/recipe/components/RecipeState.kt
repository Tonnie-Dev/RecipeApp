package com.uxstate.recipeapp.feature_recipe.presentation.recipe.components

import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe

data class RecipeState(
    val loading: Boolean = false,
    val error: String = "",
    val recipe: Recipe? = null
)
