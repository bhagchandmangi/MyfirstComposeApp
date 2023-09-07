package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.Components.CustomProfileCard
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R

@Composable
fun EmployeeDetails(data: EmployeeList) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = colorResource(id = R.color.bgcolor)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomProfileCard(data = data)

    }
    Spacer(modifier = Modifier.padding(1.dp))
//    Image(
//
//        contentDescription = "Grid Image",
//        modifier = Modifier
//            .clip(RoundedCornerShape(10.dp)),
//        alignment = Alignment.Center
//    )
    Spacer(modifier = Modifier.padding(10.dp))
    Text(
        text = data.name,
        modifier = Modifier,
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.padding(1.dp))

    Text(
        text = data.desc,
        modifier = Modifier
            .padding(6.dp),
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,


        )
}

//@Preview(showBackground = true)
//@Composable
//fun EmployeeListPreview() {
//    var data: EmployeeList
//    EmployeeDetails(data = data)
//}
