package com.example.myfirstcomposeapp.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.myfirstcomposeapp.BOTTOM_GRAPH_ROUTE
import com.example.myfirstcomposeapp.Components.ProfileScreen
import com.example.myfirstcomposeapp.Components.ProjectScreen
import com.example.myfirstcomposeapp.DETAILS
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.NavigationItem
import com.example.myfirstcomposeapp.NavigationItems
import com.example.myfirstcomposeapp.screens.CreateTaskComponent
import com.example.myfirstcomposeapp.screens.EmployeeDetails
import com.example.myfirstcomposeapp.screens.MessageScreen
import com.example.myfirstcomposeapp.screens.SalesScreen
import com.example.myfirstcomposeapp.screens.TaskScreen
import com.example.myfirstcomposeapp.screens.TeamScreen
import com.google.gson.Gson

fun NavGraphBuilder.BottomNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = NavigationItem.Message.route,
        route = BOTTOM_GRAPH_ROUTE
    ) {
        composable(NavigationItem.Message.route) {
            MessageScreen()
        }
        composable(NavigationItem.Team.route) {
            TeamScreen()
        }
        composable(NavigationItem.Project.route) {
            ProjectScreen()
        }
        composable(NavigationItem.Sales.route) {
            SalesScreen()
        }
        composable(NavigationItem.MyPage.route) {
            ProfileScreen()
        }
        detailsNavGraph(navController = navController)

    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        startDestination = NavigationItems.EmployeeDetails.route,
        route = DETAILS
    ) {
        composable("grid_detail/{item}",
            arguments = listOf(
                navArgument("item") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->

            navBackStackEntry.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, EmployeeList::class.java)
                EmployeeDetails(data = item)

            }
        }
        composable(NavigationItems.EmployeeDetails.route,
            arguments = listOf(
                navArgument("item") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->

            navBackStackEntry.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, EmployeeList::class.java)
                EmployeeDetails(data = item)

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
                TaskScreen(data = item)
            }
        }
    }
}