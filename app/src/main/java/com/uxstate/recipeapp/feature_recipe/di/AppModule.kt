package com.uxstate.recipeapp.feature_recipe

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uxstate.recipeapp.feature_recipe.data.remote.RecipeAPI
import com.uxstate.recipeapp.feature_recipe.data.remote.repository.RecipeRepositoryImpl
import com.uxstate.recipeapp.feature_recipe.domain.repository.RecipeRepository
import com.uxstate.recipeapp.feature_recipe.domain.use_cases.GetRecipeByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)

object AppModule {


    @Provides

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
    fun provideRepository (api:RecipeAPI):RecipeRepository{

        return RecipeRepositoryImpl(api = api)

    }


    @Provides
    fun providesGetRecipeByIdUseCase(repository:RecipeRepository):GetRecipeByIdUseCase{

        return GetRecipeByIdUseCase(repository = repository)
    }

    @Provides
    fun provide
}