package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins


@Composable
fun CustomProfileCard(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .background(colorResource(id = R.color.bgcolor))
    ) {
        Surface(
            Modifier
                .padding(0.dp)
                .align(alignment = Alignment.CenterEnd)
                .fillMaxWidth()
                .height(172.dp)
                .shadow(elevation = 5.dp, RoundedCornerShape(5)),
            color = Color.Transparent
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
                modifier = Modifier
            ) {
                Surface(
                    Modifier
                        .padding(top = 15.dp, bottom = 15.dp, start = 10.dp)
                        .align(alignment = Alignment.Start)
                        .width(116.dp)
                        .height(152.dp)
                        .shadow(elevation = 5.dp, RoundedCornerShape(5)), color = Color.Transparent

                ) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
                        modifier = Modifier
                    ) {
                        Image(painter = painterResource(id = R.drawable.person_6),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentScale = ContentScale.FillHeight,

                        )
                    }

                }
                Column(modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    ) {
                    Text(
                        text = "Mary Patrical",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF3A3755),
                            letterSpacing = 0.44.sp,
                        ),

                    )
                    Text(
                        text = "Mary Patrical",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF3A3755),
                            letterSpacing = 0.44.sp,
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
        Surface(
            modifier = Modifier
                .background(Color.Transparent)
                .shadow(elevation = 5.dp, RoundedCornerShape(5))
                .width(60.dp)
                .align(alignment = Alignment.CenterEnd)
                .height(202.dp)
                .padding(end = 0.dp), color = Color.Transparent
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.Primary)),
                modifier = Modifier
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(painter = painterResource(id = R.drawable.telephone_vector),
                        contentDescription = "call vector",
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        tint = colorResource(id = R.color.white)
                    )

                    Icon(painter = painterResource(id = R.drawable.mail_vetor),
                        contentDescription = "call vector",
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        tint = colorResource(id = R.color.white)
                    )
                    Icon(painter = painterResource(id = R.drawable.video_camera_vector),
                        contentDescription = "call vector",
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun CustomProfileCardPreview() {
    CustomProfileCard()
}