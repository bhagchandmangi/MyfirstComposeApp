package com.example.myfirstcomposeapp.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.myfirstcomposeapp.NavigationItems
import com.example.myfirstcomposeapp.ROOT_GRAPH_ROUTE

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItems.LoginScreen.route,
        route = ROOT_GRAPH_ROUTE
    ) {
        AuthNavGraph(navController)
        BottomNavGraph(navController)
    }
}