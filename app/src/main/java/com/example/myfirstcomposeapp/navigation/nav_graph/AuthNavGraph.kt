package com.example.myfirstcomposeapp.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myfirstcomposeapp.AUTH_GRAPH_ROUTE
import com.example.myfirstcomposeapp.Components.MainNavigationScreen
import com.example.myfirstcomposeapp.NavigationItems
import com.example.myfirstcomposeapp.screens.LoginScreen

fun NavGraphBuilder.AuthNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = NavigationItems.LoginScreen.route,
        route = AUTH_GRAPH_ROUTE
    ){
        composable(
            route = NavigationItems.LoginScreen.route
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            route = NavigationItems.MainNavigationScreen.route
        ) {
            MainNavigationScreen()
        }
    }
}