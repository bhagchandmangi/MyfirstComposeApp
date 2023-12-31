package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.background
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
import com.example.myfirstcomposeapp.Components.MessageCardListView
import com.example.myfirstcomposeapp.Components.MessageHeaderPart
import com.example.myfirstcomposeapp.Components.SearchBar
import com.example.myfirstcomposeapp.R

@Composable
fun MessageScreen() {
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)){
        Column(
            modifier = Modifier.fillMaxSize()
                .background(colorResource(id = R.color.bgcolor)),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(20.dp))

            MessageHeaderPart()
            Spacer(modifier = Modifier.height(20.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(20.dp))
            MessageCardListView()

        }
}
}

@Preview(showBackground = true)
@Composable
fun MessageScreenPreview() {
    MessageScreen()
}