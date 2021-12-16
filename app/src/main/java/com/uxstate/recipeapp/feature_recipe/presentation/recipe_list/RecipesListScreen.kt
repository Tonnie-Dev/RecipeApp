package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components.RecipeCard

@Composable
fun RecipesListScreen(
    navController: NavController,
    viewModel: RecipesListViewModel = hiltViewModel()
) {


    //get state from viewModel
    val listState by viewModel.recipesListState


    //add containing column

    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            items(items = listState.recipes){
                recipe ->

                RecipeCard(recipe = recipe, onClick = {})
            }

        }

    }
}