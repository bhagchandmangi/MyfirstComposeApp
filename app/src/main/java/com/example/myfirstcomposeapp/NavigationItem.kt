package com.example.myfirstcomposeapp

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Message : NavigationItem("home", R.drawable.message, "Message")
    object Team : NavigationItem("music", R.drawable.team, "Team")
    object Project : NavigationItem("movies", R.drawable.project, "Project")
    object Sales : NavigationItem("books", R.drawable.sale, "Sales")
    object MyPage : NavigationItem("profile", R.drawable.profile, "My Page")
}

sealed class NavigationItems(var route: String) {
    object MainNavigationScreen : NavigationItems("mainNavigationScreen")
    object LoginScreen : NavigationItems("login")
}
