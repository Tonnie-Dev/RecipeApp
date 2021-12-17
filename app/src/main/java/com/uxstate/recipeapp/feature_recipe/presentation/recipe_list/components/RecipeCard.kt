package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uxstate.recipeapp.R
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import timber.log.Timber

@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit) {
Timber.i("Recipe Card Called")
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
                .padding(vertical = 6.dp)
                .fillMaxWidth()
                .clickable(onClick = onClick),
        elevation = 8.dp
    ) {


        Column() {

            Image(
                painter = rememberImagePainter(
                    data = recipe.featuredImage,
                    builder = {
                        crossfade(true)
                        placeholder(R.drawable.loading_animation)
                    }
                ),
                modifier = Modifier
                        .fillMaxWidth()
                        .height(225.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null

            )



            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 12.dp)
            ) {

                Text(
                    text = recipe.title,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(0.85f),
                    style = MaterialTheme.typography.h5

                )
                Text(
                    text = recipe.rating.toString(),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                            .fillMaxWidth()
                            .align(CenterVertically)
                )
            }


        }


    }


}

@Preview(name = "Card")
@Composable
fun PreviewCard() {

    val recipe = Recipe(
        id = 0,
        title = "Salad",
        publisher = "",
        featuredImage = "www",
        rating = 13,
        sourceUrl = "",
        description = "Cooking Salad",
        cookingInstructions = "",
        ingredients = listOf(),
        dateAdded = "",
        dateUpdate = ""
    )


    RecipeCard(recipe, {})

}