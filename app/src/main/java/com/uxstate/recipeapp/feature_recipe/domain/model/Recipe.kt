package com.uxstate.recipeapp.feature_recipe.domain.model

data class Recipe (val id:Int,
val title:String,
val publisher:String,
val featuredImage:String,
val rating:Int,
val sourceUrl:String,
val description:String,
val cookingInstructions:String,
val ingredients:List<String>,
val dateAdded:String,
val dateUpdate:String)