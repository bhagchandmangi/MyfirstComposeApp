package com.example.myfirstcomposeapp.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.myfirstcomposeapp.DETAILS
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.NavigationItems
import com.example.myfirstcomposeapp.screens.CreateTaskComponent
import com.example.myfirstcomposeapp.screens.EmployeeDetails
import com.example.myfirstcomposeapp.screens.TaskScreen
import com.google.gson.Gson

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        startDestination = NavigationItems.EmployeeDetails.route,
        route = DETAILS
    ) {
        composable(
            NavigationItems.EmployeeDetails.route,
            arguments = listOf(
                navArgument("item") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->

            navBackStackEntry.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, EmployeeList::class.java)
                EmployeeDetails(data = item, navController)

            }
        }
        composable(NavigationItems.TaskCreateScreen.route) {
            CreateTaskComponent()
        }
        composable(NavigationItems.TaskScreen.route, arguments = listOf(
            navArgument("item") {
                type = NavType.StringType
            }
        )) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, EmployeeList::class.java)
                TaskScreen(data = item, navController)
            }
        }
    }
}