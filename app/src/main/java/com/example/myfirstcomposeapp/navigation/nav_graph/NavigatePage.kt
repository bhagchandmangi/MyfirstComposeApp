package com.example.myfirstcomposeapp.navigation.nav_graph

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfirstcomposeapp.Components.TeamGridLayout
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.screens.EmployeeDetails
import com.google.gson.Gson

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
