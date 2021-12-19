package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun ShimmerRecipeCardItem(
    color:List<Color>,
    cardHeight:Dp
) {

    val brush = Brush.linearGradient(
        colors = color,
        start = Offset(200f, 200f),
        end = Offset(200f, 200f)
    )

Surface() {

    }
}