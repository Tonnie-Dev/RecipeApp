package com.uxstate.recipeapp.feature_recipe.presentation.recipe.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe


@Composable
fun RecipeDetailsSection(recipe: Recipe) {


    Column(
        modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = SpaceBetween,

            ) {
            Text(
                text = recipe.title,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                        .fillMaxWidth(0.85f)
                        //force text to left as much as possible
                        .wrapContentWidth(Alignment.Start)
            )
            Text(
                text = recipe.rating.toString(),
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .align(CenterVertically)
            )

        }

        Text(
            text = "Updated ${recipe.dateUpdate} by ${recipe.publisher}",
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
        )


        for (ingredient in recipe.ingredients) {

            Text(text = ingredient,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }


}


@Preview(name = "RecipeDetails Preview")
@Composable
fun RecipeDetailsSectionPreview() {

    val recipe1 = Recipe(
        id = 13,
        title = "Ugali Sukuma",
        publisher = "GOAT",
        featuredImage = "",
        rating = 0,
        sourceUrl = "",
        description = "",
        cookingInstructions = "",
        ingredients = listOf("Carrots", "Kales", "Flour", "Kabiri-biri"),
        dateAdded = "25.12.2021",
        dateUpdate = "25.12.2021"
    )

    RecipeDetailsSection(recipe1)
}