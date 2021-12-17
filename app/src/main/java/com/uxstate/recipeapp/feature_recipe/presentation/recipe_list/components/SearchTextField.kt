package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchTextField(value: String, onValueChanged: (String) -> Unit, modifier: Modifier=Modifier) {


    TextField(value = value, onValueChange = onValueChanged, modifier.fillMaxWidth())

}