package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.Components.CustomProfileCard
import com.example.myfirstcomposeapp.Components.TaskListView
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@Composable
fun EmployeeDetails(data: EmployeeList) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = colorResource(id = R.color.bgcolor)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        CustomProfileCard(data = data)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.bgcolor)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 5.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomButton(
                    text = "Task in Progress",
                    colorResource(id = R.color.Primary),
                    contentColor = colorResource(
                        id = R.color.white
                    )
                )
            }


            Column {
                Row(
                    modifier = Modifier
                        .background(colorResource(id = R.color.bgcolor)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CustomButton(
                                text = "Assigned",
                                backgroundColor = colorResource(id = R.color.Primary),
                                contentColor = colorResource(R.color.Primary)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            CustomButton(
                                text = "Created",
                                backgroundColor = colorResource(id = R.color.Primary),
                                contentColor = colorResource(R.color.white)
                            )

                            Spacer(modifier = Modifier.width(8.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.pepicons_pop_menu),
                                    contentDescription = null,
                                    tint = Color.Black,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                        }
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        TaskListView(data = data)
    }

}


@Composable
fun CustomButton(text: String, backgroundColor: Color, contentColor: Color) {
    Button(
        onClick = { /* Handle button click here */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .height(24.dp)
            .shadow(elevation = 5.dp)
            .width(85.dp)

    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 8.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight(400),
                    color = colorResource(id = R.color.white),
                    letterSpacing = 0.16.sp,
                ),

                )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun EmployeeDetailsPreview() {
//    RowView()
//}