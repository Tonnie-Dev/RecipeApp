package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components.RecipeCard

@Composable
fun RecipesOverviewScreen(
    navController: NavController,
    viewModel: RecipesListViewModel = hiltViewModel()
) {


    //get states from viewModel
    val listState by viewModel.recipesListState


    //add containing column

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {

          itemsIndexed(items = listState.recipes){i,recipe ->

              RecipeCard(recipe = recipe) {}
          }

        }

        if (listState.loading){

            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        if (listState.error.isNotEmpty()){
            Text(
                text = listState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .align(Alignment.Center))
        }


        }

    }
