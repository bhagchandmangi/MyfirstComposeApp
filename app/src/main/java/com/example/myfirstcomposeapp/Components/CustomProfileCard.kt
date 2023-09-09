package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins


@Composable
fun CustomProfileCard(modifier: Modifier = Modifier, data: EmployeeList) {


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
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,

                    ) {
                    Surface(
                        Modifier
                            .padding(top = 15.dp, bottom = 15.dp, start = 10.dp)
                            .width(116.dp)
                            .height(152.dp)
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

                    Column {
                        Text(
                            text = data.name,
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF3A3755),
                                letterSpacing = 0.44.sp,
                            ),
                            modifier = Modifier.padding(top = 30.dp, start = 30.dp),
                        )
                        Text(
                            text = "IT Department",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF3A3755),
                                letterSpacing = 0.24.sp,
                            ),
                            modifier = Modifier.padding(start = 30.dp),
                        )
                        Surface(
                            Modifier
                                .padding(top = 40.dp)
                                .width(50.dp)
                                .height(20.dp),
                            color = Color.Transparent,
                            shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
                        ) {
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = colorResource(id = R.color.Primary)
                                ),
                                shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
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
                    }
                }


            }

        }
        Surface(
            modifier = Modifier
                .background(Color.Transparent)
                .shadow(elevation = 5.dp, RoundedCornerShape(5))
                .width(55.dp)
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
                    Icon(
                        painter = painterResource(id = R.drawable.telephone_vector),
                        contentDescription = "call vector",
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        tint = colorResource(id = R.color.white)
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = colorResource(id = R.color.naviconcolor),
                        thickness = 1.dp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.mail_vetor),
                        contentDescription = "call vector",
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        tint = colorResource(id = R.color.white)
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = colorResource(id = R.color.naviconcolor),
                        thickness = 1.dp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.video_camera_vector),
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

//@Preview(showBackground = true)
//@Composable
//fun CustomProfileCardPreview() {
//    data: EmployeeList
//    CustomProfileCard(data = data)
//}