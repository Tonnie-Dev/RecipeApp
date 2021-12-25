package com.uxstate.recipeapp.feature_recipe.presentation.recipe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.uxstate.recipeapp.feature_recipe.presentation.recipe.components.RecipeDetailsSection
import com.uxstate.recipeapp.feature_recipe.presentation.recipe.components.RecipeImageSection
import com.uxstate.recipeapp.feature_recipe.presentation.recipe.viewmodel.RecipeViewModel

@Composable
fun RecipeDetailScreen(

    viewModel:RecipeViewModel = hiltViewModel()
) {

    val recipeState by viewModel.recipeState
    val scrollState = rememberScrollState()

   /// Text(text = "The Id is ${recipeState.recipe?.id}")

    Column(modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)) {

        recipeState.recipe?.let {


            RecipeImageSection(recipe = it)
            RecipeDetailsSection(recipe = it)
        }


    }

}