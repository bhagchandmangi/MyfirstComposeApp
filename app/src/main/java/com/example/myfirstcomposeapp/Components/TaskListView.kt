package com.example.myfirstcomposeapp.Components
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun TaskListView() {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "EmployeeDetailsList.json")
    val gson = Gson()
    val gridSampleType = object : TypeToken<List<EmployeeList>>() {}.type
    val employeeData: List<EmployeeList> = gson.fromJson(dataFileString, gridSampleType)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.bgcolor)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(employeeData) { data ->

                CustomTaskCard(data = data)
            }
        }
    }
}


