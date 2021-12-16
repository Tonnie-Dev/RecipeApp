package com.uxstate.recipeapp.feature_recipe.presentation

sealed class Screens(val route:String){


    class RECIPES_OVERVIEW_SCREEN(route: String):Screens(route = route)
    class RECIPE_DETAILS_SCREEN(route: String):Screens(route = route)
}
