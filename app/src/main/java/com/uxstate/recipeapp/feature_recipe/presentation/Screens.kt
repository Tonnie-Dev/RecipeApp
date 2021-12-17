package com.uxstate.recipeapp.feature_recipe.presentation

sealed class Screens(val route: String) {

    object RecipesOverviewScreen : Screens("recipe_overview_screen")
    object RecipeDetailsScreen : Screens("recipe_details_screen")
}
