package com.example.myfirstcomposeapp.Components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.NavigationItem
import com.example.myfirstcomposeapp.screens.MessageScreen
import com.example.myfirstcomposeapp.screens.ProfileScreen
import com.example.myfirstcomposeapp.screens.SalesScreen
import com.example.myfirstcomposeapp.screens.TeamScreen

@Composable
fun Navigation(data: EmployeeList, navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Message.route) {
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
            ProfileScreen(navController)
        }

    }
}