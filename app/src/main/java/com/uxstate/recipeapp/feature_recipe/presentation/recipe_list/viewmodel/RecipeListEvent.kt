package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.viewmodel

sealed class RecipeListEvent {


    object FirstPageEvent : RecipeListEvent()
    object NextPageEvent : RecipeListEvent()
    //restore after process death
    object RestoreStateEvent:RecipeListEvent()
}
