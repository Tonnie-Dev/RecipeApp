package com.uxstate.recipeapp.feature_recipe.presentation.recipe.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uxstate.recipeapp.R
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe

@Composable
fun RecipeView(recipe: Recipe, scrollState: ScrollState) {

    Column(
        modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxWidth()
    ) {

        //load image

        Image(
            painter = rememberImagePainter(
                data = recipe.featuredImage,
                builder = { crossfade(true)
                placeholder(R.drawable.loading_animation)}),
            contentDescription =null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(250.dp).fillMaxWidth()
        )

    }

}