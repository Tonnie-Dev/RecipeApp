package com.uxstate.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uxstate.recipeapp.feature_recipe.data.remote.RecipeAPI
import com.uxstate.recipeapp.feature_recipe.presentation.ui.theme.RecipeAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        CoroutineScope(IO).launch {

            //build moshi

            val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()

            //build service using retrofit
            val recipeAPI = Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .baseUrl(RecipeAPI.BASE_URL)
                    .build()
                    .create(RecipeAPI::class.java)

            //get recipe

        }


        /* setContent {
             RecipeAppTheme {
                 // A surface container using the 'background' color from the theme
                 Surface(color = MaterialTheme.colors.background) {
                     Greeting("Android")
                 }
             }
         }*/
    }
}
/*
@Composable
fun Greeting(name: String) {

    Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF2F2F2))) {




            Image(
                painter = painterResource(id = R.drawable.happy_meal_small),
                contentDescription = null,
                modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
            )



       Row(
           Modifier
                   .fillMaxWidth()
                   .padding(10.dp),
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
           Text(
               text = "Happy Meal",
               textAlign = TextAlign.Start,
               fontSize = 20.sp,
               fontWeight = FontWeight.W600,

           )
           Text(
               text = "$5.99",
               fontSize = 16.sp,
               modifier = Modifier.align(CenterVertically),
               color = Color.Green
           )
       }
        
        Text(text = "800 Calories", modifier = Modifier.padding(10.dp))
        Button(onClick = { *//*TODO*//* }, modifier = Modifier
                .padding(10.dp)
                .align(CenterHorizontally)) {
            Text(text = "Order Now")
        }}
    }




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeAppTheme {
        Greeting("Android")
    }
}*/


/* Column(modifier = Modifier.verticalScroll(state = scrollState).background(color = Color(0xFFF2F2F2)).fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.happy_meal_small),
            contentDescription = null,
            modifier = Modifier.height(300.dp),
            contentScale = ContentScale.Crop
        )


        Column(modifier = Modifier.padding(16.dp)) {


            Text(text = "Happy Meal", style = TextStyle(fontSize = 26.sp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "800 Calories",style = TextStyle(fontSize = 17.sp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "$5.99",style = TextStyle(fontSize = 17.sp))
        }



    }*/