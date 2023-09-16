package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myfirstcomposeapp.Components.CustomProfileCard
import com.example.myfirstcomposeapp.Components.RowWithButton
import com.example.myfirstcomposeapp.Components.TaskListView
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R

@Composable
fun EmployeeDetails(data: EmployeeList, navHostController: NavHostController) {


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
        RowWithButton(navHostController = navHostController)
        Spacer(modifier = Modifier.height(10.dp))
        TaskListView(data = data)
    }

}




//@Preview(showBackground = true)
//@Composable
//fun EmployeeDetailsPreview() {
//    RowView()
//}