package com.uxstate.recipeapp.feature_recipe.data.remote.repository

import com.uxstate.recipeapp.feature_recipe.data.remote.RecipeAPI
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesResult
import com.uxstate.recipeapp.feature_recipe.domain.repository.RecipeRepository

class RecipeRepositoryImpl(val api: RecipeAPI) :RecipeRepository{
    override suspend fun getRecipes(): RecipesResult {

        api.getRecipes()


    }

    override suspend fun getRecipeById(id:Int): Recipe {
       return api.getRecipeById(id)
    }
}