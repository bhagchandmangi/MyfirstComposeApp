package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.Components.GridView
import com.example.myfirstcomposeapp.Components.SearchBar
import com.example.myfirstcomposeapp.Components.TeamHeaderPart
import com.example.myfirstcomposeapp.R

@Composable
fun TeamScreen() {
    Surface (color = colorResource(id = R.color.bgcolor),
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgcolor))
            .padding(20.dp)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            TeamHeaderPart()
            Spacer(modifier = Modifier.width(20.dp))
            SearchBar()
            Spacer(modifier = Modifier.width(20.dp))
            GridView(context = LocalContext.current)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamScreenPreview() {
    TeamScreen()
}