package com.uxstate.recipeapp.feature_recipe.domain.repository

import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesResult

interface RecipeRepository {

    suspend fun getRecipes(): RecipesResult
    suspend fun getRecipeById():Recipe
}