package com.uxstate.recipeapp.feature_recipe.domain.use_cases

import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.domain.model.RecipesResult
import com.uxstate.recipeapp.feature_recipe.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetRecipesUseCase (private val repository: RecipeRepository){

    operator fun invoke(  token: String,
                          page: Int,
                          query: String): Flow<Resource<RecipesResult>> = flow{


                              repository.getRecipes(token, page, query)
    }

}