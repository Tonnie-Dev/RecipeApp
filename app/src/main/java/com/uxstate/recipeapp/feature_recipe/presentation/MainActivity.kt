package com.uxstate.recipeapp.feature_recipe.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.RecipesOverviewScreen
import com.uxstate.recipeapp.feature_recipe.presentation.ui.theme.RecipeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RecipeAppTheme {


                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screens.RecipesOverviewScreen.route
                ) {
                    composable(route = Screens.RecipesOverviewScreen.route) {


                        RecipesOverviewScreen(navController = navController)
                    }

                }
            }
        }
    }
}


