package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.recipeapp.core.util.Resource
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipesUseCase
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.FoodCategory
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.getFoodCategory
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.viewmodel.RecipeListEvent.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Named


const val PAGE_SIZE = 30

//saved state keys
const val STATE_KEY_PAGE = "recipe.state.page.key"
const val STATE_KEY_QUERY = "recipe.state.query.key"
const val STATE_KEY_LIST_POSITION = "recipe.state.query.list_position"
const val STATE_KEY_SELECTED_CATEGORY = "recipe.state.query.selected_category"

@HiltViewModel
class RecipesListViewModel @Inject constructor(
    private val useCase: GetRecipesUseCase,
    @Named("auth_token") private val token: String,
    private val savedStateHandle: SavedStateHandle
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


    //store scroll position - it is not mutable as we not reacting to its changes
    var categoryScrollPosition = 0

    //value to track the page number
    var page = mutableStateOf(1)
        private set

    //track the scroll position - not observable therefore not a mutable state
   private var listScrollPosition = 0

    init {

        onTriggerEvent(FirstPageEvent)
    }


    fun  onTriggerEvent(event: RecipeListEvent){

        viewModelScope.launch {

            try {


                when(event){


                    is FirstPageEvent -> {

                        firstPageCall()
                    }
                    is NextPageEvent -> {

                        nextPageCall()
                    }
                }

            }catch (e:Exception){

                Timber.i("onTriggerEvent: Exception $e, Cause: ${e.cause}")

            }
        }
    }

   private fun firstPageCall() {
        getRecipes(token = token, page = 1, query = query.value)

    }
    //fxn to get the next page(2nd search items from the api

    private fun nextPageCall() {



            //lock to prevent loading of page too quickly when you reach the bottom
            if ((listScrollPosition + 1) >= (page.value * PAGE_SIZE)) {

                //means bottom of the page has been reached - so show loading

                recipesListState.value = recipesListState.value.copy(loading = true)
                //at that point increment the page number

                incrementPageNumber()

                Timber.i("Next Page Triggered - pageNo is ${page.value}")

                //add delay to see the loading

                //delay(1000)

                //2nd api loading when page exceed 1 - prevent duplicate list being loaded

                if (page.value > 1) {


                    getRecipes(token = token, page = page.value, query = query.value)
                    appendRecipes(recipesListState.value.recipes)
                }

                //hide progress bar
                recipesListState.value = recipesListState.value.copy(loading = false)
            }

    }


    //get recipes - 1st call, page number = 1
    private fun getRecipes(token: String, page: Int, query: String) {
        resetSearchState()
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


    fun onSearchQueryChange(text: String) {

        query.value = text

        if (text.isBlank()) {

            selectedCategory.value = null
        }
        resetSearchState()
    }


    fun onSelectedCategoryChanged(category: String) {

        //get FoodCategory Enum
        val newCategory = getFoodCategory(category)

      setSelectedCategory(newCategory )

        //call search with new category string
        onSearchQueryChange(category)

    }

    fun onCategoryScrollPositionChange(position: Int) {


categoryScrollPosition = position
    }


    private fun incrementPageNumber() {

        Timber.i("Increment Page No fxn called")

       setPage( page.value + 1)
    }

    //keeps track of the scroll position
    fun onChangeRecipeScrollPosition(position: Int) {

     setListScrollPosition(position = position)
    }


    //append new recipes to the current list of recipes
    private fun appendRecipes(recipes: List<Recipe>) {

        val currentList = ArrayList(recipesListState.value.recipes)
        currentList.addAll(recipes)
        recipesListState.value = recipesListState.value.copy(recipes = currentList)
    }


    //called when new search is executed
    private fun resetSearchState() {

        recipesListState.value = recipesListState.value.copy(recipes = listOf())
        page.value = 1
        onChangeRecipeScrollPosition(0)

    }

    fun onClearTextField() {

        query.value = ""
        setSelectedCategory(null)
    }

    private fun setListScrollPosition(position: Int){
        listScrollPosition = position
        savedStateHandle.set(STATE_KEY_LIST_POSITION, position)
    }


    private fun setPage(pageNumber:Int){
        page.value = pageNumber
        savedStateHandle.set(STATE_KEY_PAGE, pageNumber)

    }

    private fun setSelectedCategory(category: FoodCategory?){

        selectedCategory.value = category
        savedStateHandle.set(STATE_KEY_SELECTED_CATEGORY, category)
    }

    private fun setQuery(searchQuery: String)    {

        query.value =searchQuery
        savedStateHandle.set(STATE_KEY_QUERY, searchQuery)
    }
}
