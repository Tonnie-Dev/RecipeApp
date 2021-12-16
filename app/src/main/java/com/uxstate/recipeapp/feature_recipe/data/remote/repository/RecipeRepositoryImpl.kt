package com.uxstate.recipeapp.feature_recipe.data.remote.repository

import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.data.remote.RecipeAPI
import com.uxstate.recipeapp.feature_recipe.data.remote.dto.toRecipe
import com.uxstate.recipeapp.feature_recipe.data.remote.dto.toRecipeList
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
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
    ): Flow<Resource<List<Recipe>>> = flow {


        //initially emit Loading status
        emit(Resource.Loading())

        //initiate Network/API Call
        try {

            val recipeListDTO = api.getRecipes(token, page, query)

            val recipeList = recipeListDTO.toRecipeList()

            emit(Resource.Success(data = recipeList.recipes))

        }


        //if the request did not complete/ invalid response
        catch (e: HttpException) {

            //return message only, data is null
            emit(Resource.Error(message = e.localizedMessage ?: "An expected error occurred"))
        }


        //servers unreachable, parsing issue, no internet connection
        catch (e: IOException) {
//return message only, data is null
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }


    }


    override suspend fun getRecipeById(token: String, id: Int): Flow<Resource<Recipe>> = flow {

        //emit loading status initially
        emit(Resource.Loading())
        try {
            //initiate network call
            val recipe = api.getRecipeById(token, id).toRecipe()
            emit(Resource.Success(data = recipe))
        }  //if the request did not complete/ invalid response
        catch (e: HttpException) {

            //return message only, data is null
            emit(Resource.Error(message = e.localizedMessage ?: "An expected error occurred"))
        }


        //servers unreachable, parsing issue, no internet connection
        catch (e: IOException) {
//return message only, data is null
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }

    }
}


