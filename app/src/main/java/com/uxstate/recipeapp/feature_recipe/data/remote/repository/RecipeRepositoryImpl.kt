package com.uxstate.recipeapp.feature_recipe.data.remote.repository

import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesResult
import com.uxstate.recipeapp.feature_recipe.domain.repository.RecipeRepository

class RecipeRepositoryImpl :RecipeRepository{
    override suspend fun getRecipes(): RecipesResult {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeById(): Recipe {
        TODO("Not yet implemented")
    }
}