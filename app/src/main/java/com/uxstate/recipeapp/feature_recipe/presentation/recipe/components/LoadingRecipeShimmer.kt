package com.uxstate.recipeapp.feature_recipe.presentation.recipe.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingRecipeShimmer() {


    Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)) {


        Spacer(modifier = Modifier.height(250.dp))
        Spacer(modifier = Modifier
                .height(65.dp)
                .padding(8.dp))
        Spacer(modifier = Modifier
                .height(65.dp)
                .padding(8.dp))
        Spacer(modifier = Modifier
                .height(65.dp)
                .padding(8.dp))
    }
}


@Preview(name = "Recipe Shimmer")
@Composable
fun PreviewRecipeShimmer() {

    LoadingRecipeShimmer()

}