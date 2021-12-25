package com.uxstate.recipeapp.feature_recipe.domain.use_cases

import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipeByIdUseCase(private val repository: RecipeRepository) {

    operator fun invoke(token: String, id: Int): Flow<Resource<Recipe>> {


        return repository.getRecipeById(token = token, id = id)
    }


}