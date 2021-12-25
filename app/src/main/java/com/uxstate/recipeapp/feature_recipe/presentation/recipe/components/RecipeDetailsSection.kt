package com.uxstate.recipeapp.feature_recipe.presentation.recipe.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe

class RecipeDetailsSection {

    @Composable
    fun RecipeDetailsSection(recipe: Recipe) {


        Column(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = SpaceBetween
           ) {
               Text(text = recipe.title, style = MaterialTheme.typography.h5)
               Text(text = recipe.rating.toString(), style = MaterialTheme.typography.h6)

           }

        }



    }
}


@Preview(name = "RecipeDetails Preview")
@Composable
fun RecipeDetailsSectionPreview() {
    
}