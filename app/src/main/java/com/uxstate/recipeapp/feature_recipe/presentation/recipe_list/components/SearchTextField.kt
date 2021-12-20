package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    onImeAction: () -> Unit = {},
onClearTextField:()-> Unit
    ) {
    val keyboardController = LocalSoftwareKeyboardController.current


        Row {
            TextField(
                value = value,
                onValueChange = onValueChanged,

                //occupy 95% of max width to menu space
                modifier
                        .fillMaxWidth(0.9f)
                        .padding(8.dp),

                label = { Text(text = "search") },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),

                leadingIcon = {

                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                },


                trailingIcon = {

                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = null,
                        modifier = Modifier.clickable { onClearTextField() })
                },


                keyboardActions = KeyboardActions(
                    onSearch = {
                        onImeAction()
                        keyboardController?.hide()

                    }),

                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),

                colors = TextFieldDefaults.textFieldColors(

                    backgroundColor = MaterialTheme.colors.surface,
                    leadingIconColor = MaterialTheme.colors.primaryVariant,
                    trailingIconColor = MaterialTheme.colors.primaryVariant
                )

            )

            MenuButton(modifier = Modifier.align(CenterVertically)) {

            }

    }
}

@ExperimentalComposeUiApi
@Preview(name = "Preview SearchTextField")
@Composable
fun PreviewSearchTextField() {

    SearchTextField(modifier = Modifier,"Tonnie",{},{},{})

}



   

