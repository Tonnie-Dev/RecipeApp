package com.uxstate.recipeapp.feature_recipe.data.remote.repository

import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.data.remote.RecipeAPI
import com.uxstate.recipeapp.feature_recipe.data.remote.dto.toRecipesResult
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesResult
import com.uxstate.recipeapp.feature_recipe.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RecipeRepositoryImpl(private val api: RecipeAPI) : RecipeRepository {
    override suspend fun getRecipes(
        token: String,
        page: Int,
        query: String
    ): Flow<Resource<RecipesResult>> = flow {


        //initially emit Loading status
        emit(Resource.Loading())

        //initiate Network/API Call
        try {
            val recipesResultDTO = api.getRecipes(token, page, query)

            //emit RecipeResult
            emit(Resource.Success(data = recipesResultDTO.toRecipesResult()))

        }


        //if the request did not complete/ invalid response
        catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "An expected error occurred"))
        }


        //servers unreachable, parsing issue, no internet connection
        catch (e: IOException) {

            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }


    }


    override suspend fun getRecipeById(token: String, id: Int): Flow<Resource<Recipe>> {
        TODO("Not yet implemented")
    }
}


