package com.uxstate.recipeapp.feature_recipe.data.remote

import com.uxstate.recipeapp.feature_recipe.data.remote.dto.RecipeDTO
import com.uxstate.recipeapp.feature_recipe.data.remote.dto.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeAPI {


    companion object {

        const val BASE_URL = "https://food2fork.ca/"
        const val AUTH_TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }

    //search all recipes
    @GET(value = "api/recipe/search")
    suspend fun searchRecipes(
        @Header("Authorization")
        token: String,
        @Query("page")
        page: Int,
        @Query("query")
        query: String
    ): RecipeSearchResponse


    //search a single recipe
    @GET(value = "api/recipe/get")
    suspend fun getRecipe(
        @Header("Authorization")
        token: String,
        @Query("id")
        id: Int
    ): RecipeDTO


}