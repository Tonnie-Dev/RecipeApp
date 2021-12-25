package com.uxstate.recipeapp.feature_recipe.presentation.recipe.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.recipeapp.core.util.Constants
import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipeByIdUseCase
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipesUseCase
import com.uxstate.recipeapp.feature_recipe.presentation.recipe.viewmodel.RecipeEvent.GetRecipeEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Named

const val STATE_KEY_RECIPE = "state.key.recipe"
@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val useCase: GetRecipeByIdUseCase,
    @Named("auth_token")
    private val token: String,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    var recipeState = mutableStateOf(RecipeState())
        private set


    init {
        //pass the key inside get() fxn
        savedStateHandle.get<Int>(Constants.PARAM_RECIPE_ID)
                ?.let { id ->
                    //getRecipe(id = id, token = token)
                    onTriggerEvent(GetRecipeEvent(id = id))
                }


        //restore if process dies
        savedStateHandle.get<Int>(STATE_KEY_RECIPE)

    }


    private fun getRecipe(id: Int, token: String) {


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
                .launchIn(viewModelScope)
    }


    fun onTriggerEvent(event: RecipeEvent){
        try {
            when(event){

                is GetRecipeEvent -> {

                    if ( recipeState.value.recipe == null){

                        getRecipe(event.id, token = token)
                    }
                }
            }
        }
    }
}