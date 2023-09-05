package com.example.myfirstcomposeapp.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R

@Composable
fun EmployeeDetails(data:EmployeeList){

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = colorResource(id = R.color.white)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text ="Fruits Calories and Sugar",
                color = Color.White,
                fontSize =  20.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Spacer(modifier = Modifier.padding(1.dp))
        Image(painter = painterResource(
            id =  when(data.id){
                1L-> R.drawable.person_1
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
            contentDescription = "Grid Image",
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp)),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = data.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            color = Color.Black,
            fontSize =  20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(1.dp))

        Text(
            text = data.desc,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(6.dp),
            color = Color.Black,
            fontSize =  16.sp,
            fontWeight = FontWeight.Normal,


            )
    }
}


