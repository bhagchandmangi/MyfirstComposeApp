package com.example.myfirstcomposeapp.Components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myfirstcomposeapp.NavigationItem
import com.example.myfirstcomposeapp.NavigationItems
import com.example.myfirstcomposeapp.screens.LoginScreen
import com.example.myfirstcomposeapp.screens.MessageScreen
import com.example.myfirstcomposeapp.screens.TeamScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItems.LoginScreen.route) {
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
        composable(NavigationItems.MainNavigationScreen.route) {
            MainNavigationScreen()
        }
        composable(NavigationItems.LoginScreen.route) {
            LoginScreen(navController)
        }
    }
}