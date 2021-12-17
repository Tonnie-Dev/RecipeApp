package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class RecipesListViewModel @Inject constructor(
    private val useCase: GetRecipesUseCase,
    @Named("auth_token") private val token: String
) :
    ViewModel() {

    //list state
    var recipesListState = mutableStateOf(RecipesListState())
        private set

    //search query state
    var query = mutableStateOf("")
        private set

    init {

        getRecipes(token = token)
    }

    //get recipes
    private fun getRecipes(
        token: String,
        page: Int = 1,
        query: String = "Chicken"
    ) {

        //listen to flow emissions from usecase using onEach{}
        useCase(token = token, page = page, query = query).onEach {

                emission ->
            //modify state according to the emission

            when (emission) {


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
                    )
                }
                is Resource.Success -> {

                    recipesListState.value = recipesListState.value.copy(
                        loading = false,
                        error = "",
                        recipes = emission.data ?: emptyList()
                    )
                }

            }

        }
                .launchIn(viewModelScope)

    }


}
