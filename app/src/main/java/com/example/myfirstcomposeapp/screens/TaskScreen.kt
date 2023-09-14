package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.Components.RowWithButton
import com.example.myfirstcomposeapp.Components.SearchBar
import com.example.myfirstcomposeapp.Components.TaskListView
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(data: EmployeeList) {
    Scaffold(
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 10.dp)
                ) {
                    Spacer(modifier = Modifier.height(40.dp))
                    TaskHeaderPart()
                    Spacer(modifier = Modifier.height(20.dp))
                    SearchBar()
                    Spacer(modifier = Modifier.height(20.dp))
                    RowWithButton()
                    Spacer(modifier = Modifier.height(20.dp))
                    TaskListView(data = data)
                }


            }
        },
        containerColor = colorResource(R.color.bgcolor)
    )
}

@Composable
fun TaskHeaderPart() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Column {
            Row(
                modifier = Modifier.padding(0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {


                Icon(
                    painter = painterResource(id = R.drawable.task_vector),
                    contentDescription = "task",
                    modifier = Modifier
                        .size(17.dp)
                        .padding(end = 0.dp),
                    tint = colorResource(id = R.color.red)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Task",
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.Primary),
                        fontSize = 22.sp
                    ),
                )
            }
        }
        Column {
            Row(
                modifier = Modifier.padding(0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.carbon_add_filled),
                    contentDescription = "plus",
                    modifier = Modifier.size(17.dp),

                    tint = colorResource(id = R.color.naviconcolor)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "bell",
                    modifier = Modifier.size(17.dp),
                    tint = colorResource(id = R.color.naviconcolor)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.group),
                    contentDescription = "group",
                    modifier = Modifier.size(17.dp),
                    tint = colorResource(id = R.color.naviconcolor)
                )
            }

        }

    }

}

//@Preview(showBackground = true)
//@Composable
//fun PreTaskScreen() {
//    data: EmployeeList = EmployeeList
//    TaskScreen(data = data)
//}