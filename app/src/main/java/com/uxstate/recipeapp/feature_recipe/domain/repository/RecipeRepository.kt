package com.uxstate.recipeapp.feature_recipe.domain.repository

import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesResult
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    suspend fun getRecipes(token:String, page: Int, query:String): Flow<Resource<RecipesResult>>
    suspend fun getRecipeById(token: String, id:Int):Flow<Resource<Recipe>>
}