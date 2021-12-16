package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uxstate.recipeapp.R
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe

@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
                .padding(vertical = 6.dp)
                .fillMaxWidth()
                .clickable(onClick = onClick),
        elevation = 8.dp
    ) {


        Column (modifier = Modifier.fillMaxHeight()){

            Image(
                painter = painterResource(id = R.drawable.empty_plate),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.height(225.dp),
                alignment = Alignment.TopCenter
            )


            Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 12.dp)){

                Text(text = recipe.title)
                Text(text = recipe.rating.toString())
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