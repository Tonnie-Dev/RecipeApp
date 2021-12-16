package com.uxstate.recipeapp.feature_recipe.presentation.recipe

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipeByIdUseCase
import com.uxstate.recipeapp.feature_recipe.presentation.recipe.components.RecipeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class RecipeViewModel @Inject constructor(private val useCase: GetRecipeByIdUseCase) : ViewModel() {


    var recipeState = mutableStateOf(RecipeState())
        private set


    fun getRecipe(id: Int, token: String) {
//listen to emissions
        useCase(id = id, token = token).onEach {


                result ->


            when (result) {

                //modify state object depending on emissions
                is Resource.Loading -> {

                    recipeState.value = recipeState.value.copy(
                        loading = true,
                        error = "",
                        recipe = null
                    )
                }
                is Resource.Error -> {


                    recipeState.value = recipeState.value.copy(
                        loading = false,
                        error = result.message ?: "An Unknown Error Occurred",
                        recipe = null
                    )
                }

                is Resource.Success -> {
                    recipeState.value = recipeState.value.copy(
                        loading = false,
                        error = "",
                        recipe = result.data
                    )

                }
            }

        }
    }


}