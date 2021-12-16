package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.lifecycle.ViewModel
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipesListViewModel @Inject constructor(useCase:GetRecipesUseCase) :
    ViewModel() {
}