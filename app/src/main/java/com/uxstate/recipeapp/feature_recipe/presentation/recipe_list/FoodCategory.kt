package com.uxstate.recipeapp.feature_recipe.presentation.recipe_list

enum class FoodCategory(val value: String) {
    CHICKEN("Chicken"),
    BEEF("Beef"),
    PORK("Pork"),
    MILK("Milk"),
    EGGS("Eggs"),
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    PIZZA("Pizza"),
    PIE("Pie"),
    DONUT("Donut")
}


fun getAllFoodCategories(): List<FoodCategory> {
//return FoodCategory.values().toList()
    return enumValues<FoodCategory>().toList()
}



fun  getFoodCategory (food:String): FoodCategory? {

    return FoodCategory.values().toList().find { it.value == food }
}



