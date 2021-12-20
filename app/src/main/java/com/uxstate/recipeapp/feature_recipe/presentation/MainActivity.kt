package com.uxstate.recipeapp.feature_recipe.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uxstate.recipeapp.RecipeApp
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.RecipesOverviewScreen
import com.uxstate.recipeapp.feature_recipe.presentation.ui.theme.Blue800
import com.uxstate.recipeapp.feature_recipe.presentation.ui.theme.RecipeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity() : ComponentActivity() {
    //do field injection
    @Inject
    lateinit var app:RecipeApp



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//alternative is
       // this.application
        setContent {
            RecipeAppTheme(darkTheme = app.isDark.value) {
                window?.statusBarColor = Blue800.toArgb()

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screens.RecipesOverviewScreen.route
                ) {
                    composable(route = Screens.RecipesOverviewScreen.route) {


                        RecipesOverviewScreen(navController = navController,{

                            app.toggleLightTheme()
                        })
                    }

                }
            }
        }
    }
}


