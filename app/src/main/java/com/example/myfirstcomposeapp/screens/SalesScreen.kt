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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposeapp.Components.ButtonComponent
import com.example.myfirstcomposeapp.Components.MyTextField
import com.example.myfirstcomposeapp.NavigationItem
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesScreen() {
    val navHostController = rememberNavController()
    Scaffold(
//        topBar = { SalesTopBar() },
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier.padding(padding)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 10.dp)
                    ) {
                    Spacer(modifier = Modifier.height(40.dp))
                    SalesTopBar()
                    Spacer(modifier = Modifier.height(20.dp))
                    MyTextField(labelValue = "Customer Name")
                    Spacer(modifier = Modifier.height(20.dp))
                    MyTextField(labelValue = "Date")
                    Spacer(modifier = Modifier.height(20.dp))
                    MyTextField(labelValue = "Amount")
                    Spacer(modifier = Modifier.height(20.dp))
                    MyTextField(labelValue = "Status")
                    Spacer(modifier = Modifier.height(80.dp))
                    ButtonComponent(label = "Save", route = NavigationItem.Sales.route, navHostController = navHostController)
                }

            }
        },
        containerColor = colorResource(R.color.bgcolor) // Set background color to avoid the white flashing when you switch between screens
    )
}

@Composable
fun SalesTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(10.dp),
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
                    painter = painterResource(id = R.drawable.sale),
                    contentDescription = "Sales",
                    modifier = Modifier
                        .size(17.dp)
                        .padding(end = 0.dp),
                    tint = colorResource(id = R.color.red)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "ADD SALES PIPELINES",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(600),
                        color = colorResource(id = R.color.Primary),
                        letterSpacing = 0.44.sp,
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
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Message",
                    modifier = Modifier.size(17.dp),
                    tint = colorResource(id = R.color.naviconcolor)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.group),
                    contentDescription = "Message",
                    modifier = Modifier.size(17.dp),
                    tint = colorResource(id = R.color.naviconcolor)
                )
            }

        }

    }

}
@Preview(showBackground = true)
@Composable
fun SalesScreenPreview() {
    SalesScreen()
}