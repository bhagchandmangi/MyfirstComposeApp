package com.example.myfirstcomposeapp.Components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.Models.GridModel
import com.example.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridView(context: Context) {
    lateinit var courseList: List<GridModel>
    courseList = ArrayList<GridModel>()
    courseList = courseList + GridModel("Android", R.drawable.person_1)
    courseList = courseList + GridModel("JavaScript", R.drawable.person_2)
    courseList = courseList + GridModel("Python", R.drawable.person_3)
    courseList = courseList + GridModel("C++", R.drawable.person_4)
    courseList = courseList + GridModel("C#", R.drawable.person_5)
    courseList = courseList + GridModel("Java", R.drawable.person_6)
    courseList = courseList + GridModel("Node Js", R.drawable.office_men)

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(top = 10.dp),
        flingBehavior = ScrollableDefaults.flingBehavior(),
        userScrollEnabled = true,
    ) {

        items(courseList.size) {
            Card(
                onClick = {
                    Toast.makeText(
                        context,
                        courseList[it].languageName + " selected..",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier
                    .padding(8.dp)
                    .shadow(elevation = 6.dp)
                    .fillMaxWidth(),
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = courseList[it].languageImg),
                        contentDescription = "Javascript",
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .padding(5.dp)
                    )
                    Spacer(modifier = Modifier.height(9.dp))
                    Text(
                        text = courseList[it].languageName,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}

