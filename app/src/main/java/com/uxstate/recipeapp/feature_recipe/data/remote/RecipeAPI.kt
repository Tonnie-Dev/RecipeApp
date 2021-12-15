package com.uxstate.recipeapp.feature_recipe.data.remote

import com.uxstate.recipeapp.feature_recipe.data.remote.dto.RecipeDTO
import com.uxstate.recipeapp.feature_recipe.data.remote.dto.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeAPI {


    companion object {

        const val BASE_URL = "https://food2fork.ca/api/recipe/"

    }

//search all recipes
    @GET(value = "/search")
    suspend fun searchRecipes(
        @Header("Authorization")
        token: String,
        @Query("page")
        page: Int,
        @Query("query")
        query:String
    ): RecipeSearchResponse


    //search a single recipe


   
}