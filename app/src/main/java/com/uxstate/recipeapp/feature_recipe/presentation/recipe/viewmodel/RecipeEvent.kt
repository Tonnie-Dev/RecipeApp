package com.uxstate.recipeapp.feature_recipe.presentation.recipe.viewmodel

sealed class RecipeEvent{

    data class GetRecipeEvent(val id:Int):RecipeEvent(){

    }
}
