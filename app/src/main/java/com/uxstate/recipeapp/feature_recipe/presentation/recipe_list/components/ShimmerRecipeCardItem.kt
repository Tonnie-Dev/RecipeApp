package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

Surface(shape = MaterialTheme.shapes.small) {
    //surface with one child - Spacer

    //spacer matches the dimens of recipe card
    Spacer(
        modifier = Modifier
                .fillMaxWidth()
                .height(cardHeight)
                .background(brush = brush)
    )

    }
}