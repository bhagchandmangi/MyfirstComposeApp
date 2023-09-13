package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@Composable
fun CustomTaskCard(data: EmployeeList) {


    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.bgcolor))
    ) {
        Surface(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .height(70.dp)
                .shadow(elevation = 5.dp, RoundedCornerShape(5)),
            color = Color.Transparent
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
                modifier = Modifier
            ) {

                Column(
                    modifier = Modifier
                        .padding(start = 80.dp, top = 2.dp)
                ) {
                    Text(
                        text = "Task Title",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF3A3755),
                            letterSpacing = 0.3.sp,
                        )
                    )
                    Text(
                        text = "Feb 23,2023",
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFB90101),
                            letterSpacing = 0.16.sp,
                        )
                    )
                    Text(
                        text = "3 members",
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF3A3755),
                            letterSpacing = 0.16.sp,
                        )
                    )

                }
            }

        }
        Surface(
            Modifier
                .padding(top = 22.dp)
                .width(75.dp)
                .height(18.dp)
                .shadow(elevation = 4.dp)
                .align(Alignment.TopEnd),
            color = Color.Transparent,
            shape = RoundedCornerShape(topEnd = 5.dp, bottomStart = 5.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.red)
                ),
                shape = RoundedCornerShape(topEnd = 10.dp, bottomStart = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Unapproved",
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight(500),
                            color = colorResource(id = R.color.white),
                            letterSpacing = 0.16.sp,
                        ),

                        )
                }

            }
        }
        Surface(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
        ) {
            Text(
                textAlign = TextAlign.End,
                text = "The faces| Design",
                style = TextStyle(
                    fontSize = 8.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF3A3755),
                    letterSpacing = 0.16.sp,
                )
            )
        }
        Surface(
            Modifier
                .padding(end = 10.dp, bottom = 25.dp)
                .width(67.dp)
                .height(17.dp)
                .shadow(elevation = 4.dp)
                .align(Alignment.BottomEnd),
            color = Color.Transparent,
            shape = RoundedCornerShape(5.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.Primary)
                ),
                shape = RoundedCornerShape( 5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "On Duty",
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight(500),
                            color = colorResource(id = R.color.white),
                            letterSpacing = 0.16.sp,
                        ),

                        )
                }

            }
        }

        Surface(
            Modifier
                .padding(top = 15.dp, bottom = 15.dp,)
                .width(64.dp)
                .height(84.dp)
                .shadow(elevation = 5.dp, RoundedCornerShape(5)),
            color = Color.Transparent

        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(
                        id = when (data.id) {
                            1L -> R.drawable.person_1
                            2L -> R.drawable.person_2
                            3L -> R.drawable.person_3
                            4L -> R.drawable.person_4
                            5L -> R.drawable.person_5
                            6L -> R.drawable.person_6
                            7L -> R.drawable.person_1
                            8L -> R.drawable.person_2
                            9L -> R.drawable.person_3
                            10L -> R.drawable.person_4
                            11L -> R.drawable.person_5
                            12L -> R.drawable.person_6
                            13L -> R.drawable.person_1
                            14L -> R.drawable.person_2
                            15L -> R.drawable.person_3
                            16L -> R.drawable.person_4
                            17L -> R.drawable.person_5
                            else -> R.drawable.person_6
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.FillHeight,

                    )
            }
        }
        Surface(
            Modifier
                .padding(start = 50.dp, bottom = 25.dp)
                .width(64.dp)
                .height(14.dp)
                .shadow(elevation = 4.dp)
                .align(Alignment.BottomStart),
            color = Color.Transparent,
            shape = RoundedCornerShape(topEnd = 5.dp, bottomStart = 5.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.Primary)
                ),
                shape = RoundedCornerShape(topEnd = 5.dp, bottomStart = 5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = data.name,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.16.sp,
                        )
                    )
                }

            }
        }
    }
}
