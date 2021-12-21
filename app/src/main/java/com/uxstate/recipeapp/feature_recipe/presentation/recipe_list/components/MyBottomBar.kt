package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun MyBottomBar() {

    //Returns  a BottomNavigation composable


    BottomNavigation(elevation = 12.dp) {

        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null )  }
        )
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Search, contentDescription = null )  }
        )
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Face, contentDescription = null)  }
        )
    }
}