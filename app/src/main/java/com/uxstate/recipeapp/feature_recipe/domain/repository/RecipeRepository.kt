package com.uxstate.recipeapp.feature_recipe.domain.repository

import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesResult
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    suspend fun getRecipes(): Flow<RecipesResult>
    suspend fun getRecipeById():Flow<Recipe>
}