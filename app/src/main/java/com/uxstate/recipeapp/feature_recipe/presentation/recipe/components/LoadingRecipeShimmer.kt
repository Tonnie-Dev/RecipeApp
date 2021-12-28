package com.uxstate.recipeapp.feature_recipe.presentation.recipe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.anim.ShimmerAnimation

@Composable
fun LoadingRecipeShimmer(brush: Brush) {


    Column(
        modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
    ) {


        Spacer(
            modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .background(brush = brush)
        )
        Spacer(
            modifier = Modifier
                    .height(65.dp)
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(brush = brush)
        )
        Spacer(
            modifier = Modifier
                    .height(65.dp)
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(brush = brush)
        )
        Spacer(
            modifier = Modifier
                    .height(65.dp)
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(brush = brush)
        )
    }
}


@Composable
fun ShowRecipeDetailShimmer() {


    ShimmerAnimation { brush ->
        LoadingRecipeShimmer(brush = brush)
    }
}
