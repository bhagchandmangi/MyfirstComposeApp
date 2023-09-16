package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.Models.EmployeeList
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun MessageCardListView() {
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

                MessageCardviewComponent(data = data)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun MessageCardviewComponent(data: EmployeeList) {

    Surface(
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        color = colorResource(id = R.color.white)
    ) {
        Card(
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 5.dp),
        ) {

            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(4.dp))
                    .background(color = colorResource(id = R.color.white))


            ) {

                Row(
                    modifier = Modifier
                        .height(intrinsicSize = IntrinsicSize.Max)
                        .background(
                            colorResource(
                                id = R.color.white
                            )
                        ),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    ProfilePictureComposable(data = data)
                    ProfileContentComposable(data = data)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.white)),
                contentAlignment = Alignment.BottomEnd
            ) {

                Text(
                    text = "23 min ago",
                    style = TextStyle(
                        fontSize = 9.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(500),
                        color = colorResource(id = R.color.Primary),
                        letterSpacing = 0.18.sp,
                    )
                )
            }
        }
    }
}

@Composable
fun ProfilePictureComposable(data: EmployeeList) {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = colorResource(id = R.color.white)),
        modifier = Modifier
            .size(48.dp)
            .background(colorResource(id = R.color.white))


    ) {
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
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(48.dp),
            contentDescription = "Profile picture holder"
        )
    }
}

@Composable
fun ProfileContentComposable(data: EmployeeList) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
            .background(colorResource(id = R.color.white)),
        verticalArrangement = Arrangement.aligned(Alignment.CenterVertically)
    ) {

        Text(
            text = data.name,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight(500),
                color = colorResource(id = R.color.Secondary),
                letterSpacing = 0.3.sp,
            )
        )
        Text(
            text = "Hello sir, Thank for your\n" +
                    "message! we will get back to you\n" +
                    "within 24 hours...",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight(400),
                color = colorResource(id = R.color.textColor),
                letterSpacing = 0.24.sp,
            )

        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MessageCardviewComponent()
//}