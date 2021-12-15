package com.uxstate.recipeapp.feature_recipe.data.remote.repository

import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.data.remote.RecipeAPI
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesResult
import com.uxstate.recipeapp.feature_recipe.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow

class RecipeRepositoryImpl(val api: RecipeAPI) :RecipeRepository{
    override suspend fun getRecipes(
        token: String,
        page: Int,
        query: String
    ): Flow<Resource<RecipesResult>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeById(token: String, id: Int): Flow<Resource<Recipe>> {
        TODO("Not yet implemented")
    }

}