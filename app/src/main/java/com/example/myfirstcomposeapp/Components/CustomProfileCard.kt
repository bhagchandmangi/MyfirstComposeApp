package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width


@Composable
fun CustomProfileCard(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {
        Surface(
            Modifier
                .padding(vertical = 20.dp)
                .align(alignment = Alignment.CenterEnd)
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .shadow(elevation = 5.dp, RoundedCornerShape(5)), color = Color.Transparent
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.Red),
                modifier = Modifier
            ) {

            }
        }
        Surface(
            modifier = Modifier
                .background(Color.Transparent)
                .shadow(elevation = 5.dp, RoundedCornerShape(5))
                .width(50.dp)
                .align(alignment = Alignment.CenterEnd)
                .fillMaxHeight()
                .padding(end = 0.dp), color = Color.Transparent
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.Red),
                modifier = Modifier
            ) {

            }
        }


    }
}