package com.uxstate.recipeapp.feature_recipe.domain.model

import com.uxstate.recipeapp.feature_recipe.data.remote.dto.RecipeDTO

data class RecipesResult(val count: Int,
                         val results: List<RecipeDTO>)
