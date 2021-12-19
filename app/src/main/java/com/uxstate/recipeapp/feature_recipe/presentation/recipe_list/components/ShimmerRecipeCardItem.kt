package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerRecipeCardItem(
    brush: Brush
) {

    Column(modifier = Modifier.padding(16.dp)) {
       /* spacer with brush receiving from [ShimmerAnimation]
        Composable which is the Animation you are gonna create.*/
        Spacer(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(brush = brush)
        )
        Spacer(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(vertical = 8.dp)
                    .background(brush = brush)
        )

    }


}


