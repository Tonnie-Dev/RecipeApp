package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun DefaultSnackbar(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    onDismiss: () -> Unit
) {


    SnackbarHost(hostState = snackbarHostState,
        snackbar = { snackbarData ->
          Text(
                text = snackbarData.message,
                style = MaterialTheme.typography.body2,
                color = Color.White
            )
        }
    )
}