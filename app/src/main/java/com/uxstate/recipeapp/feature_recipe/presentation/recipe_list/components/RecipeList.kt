package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.viewmodel.PAGE_SIZE
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.viewmodel.RecipeListEvent

@Composable
fun RecipeList(
    recipes: List<Recipe>,
    onChangeRecipeScrollPosition: (Int) -> Unit,
    page: Int,
    loading: Boolean,
    onTriggerEvent: (RecipeListEvent) -> Unit,
    onClickRecipeCard: (Int) -> Unit
) {


    LazyColumn() {

        itemsIndexed(items = recipes) { position, recipe ->


            onChangeRecipeScrollPosition(position)


            //trigger for pagination
            if ((position + 1) >= (page * PAGE_SIZE) && !loading) {

                onTriggerEvent(RecipeListEvent.NextPageEvent)


            }

            RecipeCard(
                recipe = recipe,
                onClick = onClickRecipeCard
            )
        }

    }
}