package com.example.myfirstcomposeapp.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myfirstcomposeapp.BOTTOM_GRAPH_ROUTE
import com.example.myfirstcomposeapp.Components.ProfileScreen
import com.example.myfirstcomposeapp.Components.ProjectScreen
import com.example.myfirstcomposeapp.NavigationItem
import com.example.myfirstcomposeapp.screens.MessageScreen
import com.example.myfirstcomposeapp.screens.SalesScreen
import com.example.myfirstcomposeapp.screens.TeamScreen

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

    }
}