package com.uxstate.recipeapp.feature_recipe.presentation.recipe

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.uxstate.recipeapp.feature_recipe.presentation.recipe.viewmodel.RecipeViewModel

@Composable
fun RecipeDetailScreen(

    viewModel:RecipeViewModel = hiltViewModel()
) {

    val recipeState by viewModel.recipeState

    Text(text = "The Id is ${recipeState.recipe?.id}")

}