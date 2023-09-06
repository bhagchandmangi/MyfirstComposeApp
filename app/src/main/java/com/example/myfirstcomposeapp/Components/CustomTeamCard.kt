package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.myfirstcomposeapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.ui.theme.Poppins
import com.google.gson.Gson

@Composable
fun CustomTeamCard(data: EmployeeList, navController: NavController)
{
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(250.dp)
                .shadow(elevation = 10.dp)
                .clickable {
                    val itemVal = Gson().toJson(data)
                    navController.navigate("grid_detail/$itemVal")
                },
            colors = CardDefaults.cardColors(
                colorResource(id = R.color.Primary)
            ),
            shape = RoundedCornerShape(16.dp),

            ) {
            Column(
                modifier = Modifier
                    .background(colorResource(id = R.color.Primary))
                    .shadow(elevation = 9.dp, spotColor = Color(0x00000000), ambientColor = Color(0x00000000))
            ) {
                Image(painter =
                painterResource(
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
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                                Text(text = data.name,
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontFamily = Poppins,
                                        color = colorResource(id = R.color.white),
                                        letterSpacing = 0.3.sp
                                    )
                                )
                                Text(text = "IT",
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        fontFamily = Poppins,
                                        color = colorResource(id = R.color.white),
                                        letterSpacing = 0.2.sp
                                    ))
                    }
                    Column {
                        Text(text = "on duty",
                            style = TextStyle(
                                fontSize = 8.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF05FF00),
                                letterSpacing = 0.16.sp,
                            ))
                        Row(
                            modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.call_vector),
                                contentDescription = "image description",
                                Modifier
                                    .width(10.dp)
                                    .height(7.dp)

                            )
                            Spacer(modifier = Modifier
                                .height(20.dp)
                                .width(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.message_vector),
                                contentDescription = "image description",
                                Modifier
                                    .width(10.dp)
                                    .height(7.dp)
                            )
                        }
                    }

                }
            }
        }
        
    }
}

