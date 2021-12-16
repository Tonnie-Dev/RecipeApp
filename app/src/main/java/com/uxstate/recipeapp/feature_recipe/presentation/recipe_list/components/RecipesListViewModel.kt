package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class RecipesListViewModel @Inject constructor(private val useCase: GetRecipesUseCase) :
    ViewModel() {

//State
    var recipesListState = mutableStateOf(RecipesListState())
private set

    init {
        TODO()

        getRecipes()
    }

    //get recipes
    fun getRecipes(
        token: String,
        page: Int,
        query: String
    ) {

        //listen to flow emissions from usecase using onEach{}
        useCase(token = token, page = page, query = query).onEach {

            emission ->
            //modify state according to the emission

            when(emission){


                is Resource.Loading -> {


                    recipesListState.value = recipesListState.value.copy(
                        loading = true,
                        error = "",
                        recipes = emptyList()
                    )
                }

                is Resource.Error -> {
                    recipesListState.value = recipesListState.value.copy(
                        loading = false,
                        error = emission.message ?: "Unknown Error Occurred",
                        recipes = emptyList()
                    )}
                is Resource.Success -> {

                    recipesListState.value = recipesListState.value.copy(
                        loading = false,
                        error = "",
                        recipes = emission.data?: emptyList()
                    )}

                }

            }

        }


    }
