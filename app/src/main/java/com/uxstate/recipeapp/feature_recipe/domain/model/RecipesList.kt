package com.uxstate.recipeapp.feature_recipe.domain.model

import com.uxstate.recipeapp.feature_recipe.data.remote.dto.RecipeDTO

data class RecipesList(val count: Int,
                       val results: List<RecipeDTO>)
