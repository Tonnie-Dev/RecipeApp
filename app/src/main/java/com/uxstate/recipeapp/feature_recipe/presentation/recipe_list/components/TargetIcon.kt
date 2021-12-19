package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun CircleIcon(radius: Float, color: Color) {

    Canvas(
        modifier = Modifier
                .fillMaxWidth()
                .heightIn(55.dp)
    ) {
        //use trailing lambda for onDrawArgument

        drawCircle(brush = SolidColor(color), radius = radius)

    }
}


@Composable
fun HeartIcon() {

    Image(
        imageVector = Icons.Filled.Favorite,
        contentDescription = null,
        modifier = Modifier.size(75.dp, 75.dp)
    )
}