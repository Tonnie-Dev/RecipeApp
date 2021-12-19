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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun ChipsRow(
    selectedCategory: FoodCategory?,
    modifier: Modifier = Modifier,
    categories: List<FoodCategory>,
    scrollState: ScrollState,
  scrollPosition:Int,
    coroutineScope: CoroutineScope,
    onSelectedCategoryChange: (String) -> Unit,
    onExecuteSearch: () -> Unit
) {


    Row(
        modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 8.dp)
                .horizontalScroll(scrollState)
    ) {

        //when the row is recomposed it resets to the scroll position stored by ViewModel
        coroutineScope.launch {
            scrollState.scrollTo(scrollPosition)
        }
        for (category in categories) {

            //restoring scrolling position but should called in a Coroutine


            FoodCategoryChip(
                category = category.value,
                isSelected = selectedCategory == category,
                onSelectedCategoryChange = onSelectedCategoryChange,
                onExecuteSearch = onExecuteSearch
            )
        }


    }

}