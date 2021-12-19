package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.FoodCategory


@Composable
fun ChipsRow(
    selectedCategory: FoodCategory?,
    modifier: Modifier = Modifier,
    categories: List<FoodCategory>,
    scrollState: ScrollState,
  scrollPosition:Int,
    onSelectedCategoryChange: (String) -> Unit,
    onExecuteSearch: () -> Unit
) {


    Row(
        modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 8.dp)
                .horizontalScroll(scrollState, enabled = true)
    ) {

        for (category in categories) {

            //restoring scrolling position
                //scrollState.scrollTo(scrollPosition)

            FoodCategoryChip(
                category = category.value,
                isSelected = selectedCategory == category,
                onSelectedCategoryChange = onSelectedCategoryChange,
                onExecuteSearch = onExecuteSearch
            )
        }


    }

}