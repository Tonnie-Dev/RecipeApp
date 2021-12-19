package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipesUseCase
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.FoodCategory
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.getFoodCategory
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

    var selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)
        private set


    //store scroll position
    var scrollPosition = 0f

    init {

        getRecipes()
    }

    //get recipes
    fun getRecipes() {

        //listen to flow emissions from usecase using onEach{}
        useCase(token = token, page = 1, query = query.value).onEach {

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


    fun onSearchQueryChange(text: String) {

        query.value = text

    }


    fun onSelectedCategoryChanged(category:String){

        //get FoodCategory Enum
        val newCategory = getFoodCategory(category)

        selectedCategory.value = newCategory

        //call search with new category string
        onSearchQueryChange(category)

    }
    fun onClearTextField() {

        query.value = ""
    }



}
