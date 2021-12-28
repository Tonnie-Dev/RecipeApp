package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.anim.ShimmerAnimation

@Composable
fun ShimmerRecipeCardItem(
    brush: Brush
) {

    Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)) {
       /* spacer with brush receiving from [ShimmerAnimation]
        Composable which is the Animation you are gonna create.*/
        Spacer(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp)
                    .background(brush = brush)
        )
        Spacer(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .padding(vertical = 8.dp)
                    .background(brush = brush)
        )

    }


}


@Composable
fun ShowRecipeListShimmer() {
    LazyColumn() {

        repeat(5) {

            item {
                ShimmerAnimation { brush -> ShimmerRecipeCardItem(brush = brush) }
            }
        }
    }


}


