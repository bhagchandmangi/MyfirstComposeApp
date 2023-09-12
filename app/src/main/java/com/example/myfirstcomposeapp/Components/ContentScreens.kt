package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.R

@Composable
fun ProjectScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgcolor))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Project View",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.Primary),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgcolor))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Profile View",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.Primary),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

