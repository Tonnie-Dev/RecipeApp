package com.uxstate.recipeapp.feature_recipe

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uxstate.recipeapp.RecipeApp
import com.uxstate.recipeapp.feature_recipe.data.remote.RecipeAPI
import com.uxstate.recipeapp.feature_recipe.data.remote.repository.RecipeRepositoryImpl
import com.uxstate.recipeapp.feature_recipe.domain.repository.RecipeRepository
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipeByIdUseCase
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {


    @Provides
    @Singleton
    fun provideRecipeAPI(): RecipeAPI {

        //build Moshi
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        return Retrofit.Builder()
                .baseUrl(RecipeAPI.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(RecipeAPI::class.java)


    }



    @Provides
    @Singleton
    fun provideRepository (api:RecipeAPI):RecipeRepository{

        return RecipeRepositoryImpl(api = api)

    }


    @Provides
    @Singleton
    fun provideGetRecipeByIdUseCase(repository:RecipeRepository):GetRecipeByIdUseCase{

        return GetRecipeByIdUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun provideGetRecipesUseCase(repository:RecipeRepository):GetRecipesUseCase{


        return GetRecipesUseCase(repository = repository)
    }

    @Provides
    @Singleton
    @Named("auth_token") // for differentiating types e.g. String

    fun provideAuthToken():String{

        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }

    @Provides
    @Singleton
    fun provideApplication(@ApplicationContext app: Context):RecipeApp {

        return app as RecipeApp
    }
}