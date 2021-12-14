package com.uxstate.recipeapp.feature_recipe.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.uxstate.recipeapp.feature_recipe.domain.model.Recipe

@JsonClass(generateAdapter = true)
data class RecipeDTO(
    @Json(name = "cooking_instructions")
    val cookingInstructions: String?,
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
    @Json(name = "pk")
    val id: Int,
    val publisher: String,
    val rating: Int,
    @Json(name = "source_url")
    val sourceUrl: String,
    val title: String
)

fun RecipeDTO.toRecipe():Recipe{

    if (cookingInstructions.isNullOrEmpty()) {

        return Recipe(
            id = id,
            title = title,
            publisher = publisher,
            featuredImage = featuredImage,
            rating = rating,
            sourceUrl = sourceUrl,
            description = description,
            cookingInstructions = "",
            ingredients = ingredients,
            dateAdded = dateAdded,
            dateUpdate = dateUpdated
        )

    } else {

        return Recipe(
            id = id,
            title = title,
            publisher = publisher,
            featuredImage = featuredImage,
            rating = rating,
            sourceUrl = sourceUrl,
            description = description,
            cookingInstructions = cookingInstructions,
            ingredients = ingredients,
            dateAdded = dateAdded,
            dateUpdate = dateUpdated
        )
    }



}


