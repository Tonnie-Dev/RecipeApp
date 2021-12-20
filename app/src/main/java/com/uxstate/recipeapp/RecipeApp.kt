package com.uxstate.recipeapp

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class RecipeApp:Application() {

    //this should be persisted in SharedPrefs or DB
    val isDark = mutableStateOf(false)

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

    fun  toggleLightTheme(){

        isDark.value = !isDark.value
    }
}