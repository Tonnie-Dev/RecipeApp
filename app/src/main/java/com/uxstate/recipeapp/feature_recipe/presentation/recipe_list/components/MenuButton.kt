package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun MenuButton(
    modifier: Modifier = Modifier,
    onToggleTheme: () -> Unit,

) {


    IconButton(onClick = onToggleTheme) {
        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
    }
/*ConstraintLayout() {
    //create id
    val menu = createRef()

    //widget to be constrained
    IconButton(onClick = onToggleTheme,
        modifier.constrainAs(menu){
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }) {

        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
    }
}*/

}

@Preview(name = "PreviewMenutButton")
@Composable
fun PreviewMenuButton() {
    MenuButton() {
        
    }
}