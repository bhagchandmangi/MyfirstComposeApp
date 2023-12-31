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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposeapp.Components.CustomProfileCard
import com.example.myfirstcomposeapp.Components.HeaderPartOne
import com.example.myfirstcomposeapp.Components.RowWithButton
import com.example.myfirstcomposeapp.Components.TaskListView
import com.example.myfirstcomposeapp.Components.getJsonDataFromAsset
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun ProfileScreen(navHostController: NavHostController) {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "EmployeeDetailsList.json")
    val gson = Gson()
    val gridSampleType = object : TypeToken<List<EmployeeList>>() {}.type
    val data: EmployeeList = gson.fromJson(dataFileString, gridSampleType)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = colorResource(id = R.color.bgcolor)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        HeaderPartOne(title = "My Profile", icon1 = R.drawable.left_arrow, icon2 = R.drawable.bell, icon3 = R.drawable.group)
        Spacer(modifier = Modifier.height(10.dp))
        CustomProfileCard(data = data)
        Spacer(modifier = Modifier.height(10.dp))
        RowWithButton(navHostController = navHostController)
        Spacer(modifier = Modifier.height(10.dp))
        TaskListView(data = data)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    //val data: EmployeeList = EmployeeList(1, "john", "my name is john")
    val navHostController = rememberNavController()
    ProfileScreen(navHostController)
}