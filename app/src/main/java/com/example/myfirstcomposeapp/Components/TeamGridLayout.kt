package com.example.myfirstcomposeapp.Components


import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.screens.EmployeeDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ExperimentalFoundationApi
@Composable
fun TeamGridLayout(navController : NavController) {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "EmployeeDetailsList.json")
    val gson = Gson()
    val gridSampleType = object : TypeToken<List<EmployeeList>>(){}.type
    val employeeData : List<EmployeeList> = gson.fromJson(dataFileString,gridSampleType)
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(top = 10.dp),
                flingBehavior = ScrollableDefaults.flingBehavior() ,
                userScrollEnabled= true,
                ) {
                items(employeeData) {data->
                    EmployeeDataGridItem(data = data, navController = navController )
                }

            }}
}

@Composable
fun EmployeeDataGridItem(data: EmployeeList, navController: NavController) {
    Card(modifier = Modifier
        .clickable {
            val itemVal = Gson().toJson(data)
            navController.navigate("grid_detail/$itemVal")
        }
        .padding(10.dp)
        .fillMaxSize()
        .shadow(
            elevation = 5.dp,
            shape = RoundedCornerShape(5.dp)
        ),
    ) {
        Column(modifier = Modifier) {
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
                contentDescription = "Grid Image",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(5.dp)),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = data.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Text(
                text = data.desc,
                modifier = Modifier
                    .padding(7.dp, 0.dp, 0.dp, 20.dp),
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis

            )


        }
    }
}

fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavigatePage(){

    val navHostController = rememberNavController()


    NavHost(
        navController = navHostController,
        startDestination = "employee_data"
    ){
        composable("employee_data"){
            TeamGridLayout(navController = navHostController)
        }
        composable("grid_detail/{item}",
            arguments = listOf(
                navArgument("item"){
                    type = NavType.StringType
                }
            )
        ){navBackStackEntry ->

            navBackStackEntry.arguments?.getString("item")?.let { json->
                val item = Gson().fromJson(json,EmployeeList::class.java)
                EmployeeDetails(data = item)

            }
        }
    }



}


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TeamGridPreview() {
    val navController = rememberNavController()
    TeamGridLayout(navController = navController)
}

