package com.example.myfirstcomposeapp.Components


import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
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

@SuppressLint("SuspiciousIndentation")
@ExperimentalFoundationApi
@Composable
fun TeamGridLayout(navController: NavController) {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "EmployeeDetailsList.json")
    val gson = Gson()
    val gridSampleType = object : TypeToken<List<EmployeeList>>() {}.type
    val employeeData: List<EmployeeList> = gson.fromJson(dataFileString, gridSampleType)
   
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.bgcolor)),
        ) {
            items(employeeData) { data ->
                CustomTeamCard(data = data, navController = navController)
            }
        }
}


fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavigatePage() {

    val navHostController = rememberNavController()


    NavHost(
        modifier = Modifier
            .background(colorResource(id = R.color.bgcolor)),
        navController = navHostController,
        startDestination = "employee_data"
    ) {
        composable("employee_data") {
            TeamGridLayout(navController = navHostController)
        }
        composable("grid_detail/{item}",
            arguments = listOf(
                navArgument("item") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->

            navBackStackEntry.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, EmployeeList::class.java)
                EmployeeDetails(data = item, navHostController)

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

