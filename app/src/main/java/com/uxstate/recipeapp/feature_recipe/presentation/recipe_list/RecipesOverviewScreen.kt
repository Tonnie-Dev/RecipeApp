package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components.*
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.viewmodel.PAGE_SIZE
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.viewmodel.RecipesListViewModel
import timber.log.Timber

@ExperimentalComposeUiApi
@Composable
fun RecipesOverviewScreen(
    navController: NavController,
    onToggleTheme: () -> Unit,
    viewModel: RecipesListViewModel = hiltViewModel()
) {


    //get states from viewModel
    val listState by viewModel.recipesListState
    val query by viewModel.query
    val categories = FoodCategory.values()
            .toList()

    //observe page change
    val page by viewModel.page

    val scrollState = rememberScrollState()
    //retrieve selected category from the viewModel
    val selectedCategory by viewModel.selectedCategory

    //retrieve scroll position
    val scrollPosition: Int = viewModel.categoryScrollPosition

    val coroutineScope = rememberCoroutineScope()
    //add containing column


    Scaffold(

        topBar = {


            Surface(
                elevation = 8.dp,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.surface

            ) {
                Column {
                    SearchTextField(
                        value = query,
                        onValueChanged = viewModel::onSearchQueryChange,
                        onImeAction = viewModel::firstPageCall,
                        onClearTextField = viewModel::onClearTextField,
                        onToggleTheme = onToggleTheme
                    )

                    ChipsRow(
                        selectedCategory = selectedCategory,
                        categories = categories,
                        scrollState = scrollState,
                        scrollPosition = scrollPosition,
                        coroutineScope = coroutineScope,
                        onSelectedCategoryChange = {

                            viewModel.onSelectedCategoryChanged(it)
                            viewModel.onCategoryScrollPositionChange(scrollState.value)

                        },
                        onExecuteSearch = viewModel::firstPageCall
                    )


                }

            }

        },

        ) {


        Box(
            modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.surface)
        ) {

            if (listState.loading && listState.recipes.isEmpty()) {
//list.isEmpty() ensures we only show shimmer if there is brand new search
                ShowShimmer()
            } else {
                LazyColumn() {

                    itemsIndexed(items = listState.recipes) { position, recipe ->

                        Timber.i("My Scroll Position is: $position")
                        viewModel.onChangeRecipeScrollPosition(position)


                        //trigger for pagination
                        if ((position + 1) >= (page * PAGE_SIZE) && !listState.loading) {

                            viewModel.nextPage()


                        }

                        RecipeCard(recipe = recipe) {}
                    }

                }
            }




            if (listState.error.isNotEmpty()) {
                Text(
                    text = listState.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)

                )
            }


        }
        CircularIndeterminateProgressBar(isDisplayed = listState.loading, verticalBias = 0.3f)
    }


}
