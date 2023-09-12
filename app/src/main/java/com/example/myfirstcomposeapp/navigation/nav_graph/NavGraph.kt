package com.example.myfirstcomposeapp.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.myfirstcomposeapp.AUTH_GRAPH_ROUTE
import com.example.myfirstcomposeapp.ROOT_GRAPH_ROUTE

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AUTH_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        AuthNavGraph(navController)
        BottomNavGraph(navController)
    }
}