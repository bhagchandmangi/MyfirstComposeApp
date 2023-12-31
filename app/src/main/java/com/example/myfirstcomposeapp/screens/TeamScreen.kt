package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.Components.HeaderPartOne
import com.example.myfirstcomposeapp.Components.SearchBar
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.navigation.nav_graph.NavigatePage

@Composable
fun TeamScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgcolor)) // Replace with your desired color
    ) {
        // Your preview content goes here
        Surface(
            color = colorResource(id = R.color.bgcolor),
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderPartOne(title = "Team", icon1 = R.drawable.team, icon2 = R.drawable.bell, icon3 = R.drawable.group)
                Spacer(modifier = Modifier.height(10.dp))
                SearchBar()
                Spacer(modifier = Modifier.height(10.dp))
                NavigatePage()
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TeamScreenPreview() {
    TeamScreen()
}