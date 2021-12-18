package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.FoodCategory


@Composable
fun ChipsRow(
    modifier: Modifier = Modifier,
    categories: List<FoodCategory>,
    scrollState: ScrollState
) {


    Row(
        modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState, enabled = true)
    ) {

        for (category in categories){

            Text(text = category.value)
        }


    }

}