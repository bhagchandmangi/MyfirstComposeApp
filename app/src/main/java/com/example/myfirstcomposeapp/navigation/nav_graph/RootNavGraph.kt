package com.example.myfirstcomposeapp.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myfirstcomposeapp.AUTH_GRAPH_ROUTE
import com.example.myfirstcomposeapp.Components.MainNavigationScreen
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.NavigationItems
import com.example.myfirstcomposeapp.ROOT_GRAPH_ROUTE

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AUTH_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        AuthNavGraph(navController)
        composable(NavigationItems.MainNavigationScreen.route) {
            MainNavigationScreen()
        }
    }
}