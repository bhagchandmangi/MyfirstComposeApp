package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.R

@Composable
fun YourCustomLayout() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // First Card that fills max width
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .shadow(elevation = 4.dp)// Background color for the first card

        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "First Text",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Second Text",
                    fontSize = 16.sp
                )
                Text(
                    text = "Third Text",
                    fontSize = 16.sp
                )
            }
        }

        // Second Card with an image background, larger height, and width of 50.dp
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Adjust the height as needed
                .width(50.dp) // Width of 50.dp
                .align(Alignment.TopStart)
                .shadow( elevation = 4.dp) // Background color for the second card

        ) {
            // You can use an ImagePainter or any other method to set your image
            val imagePainter: Painter = painterResource(id = R.drawable.person_6)

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewYourCustomLayout() {
    YourCustomLayout()
}