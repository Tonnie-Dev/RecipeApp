package com.uxstate.recipeapp.feature_recipe.domain.repository

import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe

interface RecipeRepository {

    suspend fun getRecipes()
    suspend fun getRecipeById():Recipe
}