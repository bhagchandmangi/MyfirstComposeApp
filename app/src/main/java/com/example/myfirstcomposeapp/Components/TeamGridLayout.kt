package com.example.myfirstcomposeapp.Components


import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.screens.EmployeeDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ExperimentalFoundationApi
@Composable
fun TeamGridLayout(navController : NavController) {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "EmployeeDetailsList.json")
    val gson = Gson()
    val gridSampleType = object : TypeToken<List<EmployeeList>>(){}.type
    val employeeData : List<EmployeeList> = gson.fromJson(dataFileString,gridSampleType)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgcolor)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(top = 10.dp),
                userScrollEnabled= true,
                ) {
                items(employeeData) {data->
                    CustomTeamCard(data = data, navController = navController)
                }

            }}
}


fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavigatePage(){

    val navHostController = rememberNavController()


    NavHost(
        navController = navHostController,
        startDestination = "employee_data"
    ){
        composable("employee_data"){
            TeamGridLayout(navController = navHostController)
        }
        composable("grid_detail/{item}",
            arguments = listOf(
                navArgument("item"){
                    type = NavType.StringType
                }
            )
        ){navBackStackEntry ->

            navBackStackEntry.arguments?.getString("item")?.let { json->
                val item = Gson().fromJson(json,EmployeeList::class.java)
                EmployeeDetails(data = item)

            }
        }
    }



}


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TeamGridPreview() {
    val navController = rememberNavController()
    TeamGridLayout(navController = navController)
}

