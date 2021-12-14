package com.uxstate.recipeapp.feature_recipe.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "cooking_instructions")
    val cookingInstructions: Any?,
    @Json(name = "date_added")
    val dateAdded: String,
    @Json(name = "date_updated")
    val dateUpdated: String,
    val description: String,
    @Json(name = "featured_image")
    val featuredImage: String,
    val ingredients: List<String>,
    @Json(name = "long_date_added")
    val longDateAdded: Int,
    @Json(name = "long_date_updated")
    val longDateUpdated: Int,
    val pk: Int,
    val publisher: String,
    val rating: Int,
    @Json(name = "source_url")
    val sourceUrl: String,
    val title: String
)