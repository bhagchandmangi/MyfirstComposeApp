package com.example.myfirstcomposeapp.screens

import DottedProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.Components.MyTextField
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTaskComponent() {
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
                    TaskHeader()
                    Spacer(modifier = Modifier.height(20.dp))
                    MyTextField(labelValue = "Task Title")
                    Spacer(modifier = Modifier.height(20.dp))
                    DesTextField(labelValue = "Description ( Max 400 characters)")
                    Spacer(modifier = Modifier.height(20.dp))
                    VoiceComponent()
                    Spacer(modifier = Modifier.height(20.dp))
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomButtonWithIcon(text = "Start Date")
                        Spacer(modifier = Modifier.width(10.dp))
                        CustomButtonWithIcon(text = "End Date")
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    TaskLevelComponent()

                }


            }
        },
        containerColor = colorResource(R.color.bgcolor)
    )
}

@Composable
fun CustomButtonWithIcon(text: String) {
    Surface(
        modifier = Modifier
            .width(95.dp)
            .height(47.dp)
            .padding(horizontal = 5.dp)
            .clickable { },
        color = colorResource(id = R.color.white),
        shadowElevation = 5.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(95.dp)
                .height(47.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.calendar_vector),
                contentDescription = "microphone",
                tint = colorResource(id = R.color.textColor),
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
                    .clickable {

                    }
            )
            Spacer(modifier = Modifier.width(1.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight(500),
                    color = colorResource(id = R.color.textColor),
                    letterSpacing = 0.24.sp,
                )
            )
        }

    }
}

@Composable
fun VoiceComponent() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier
                .width(310.dp)
                .padding(horizontal = 5.dp)
                .height(47.dp),
            color = colorResource(id = R.color.white),
            shadowElevation = 5.dp,
            shape = RoundedCornerShape(10.dp)
        ) {

            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .width(17.dp)
                        .height(17.dp),
                    painter = painterResource(id = R.drawable.play_vector),
                    contentDescription = "play button",
                    tint = colorResource(id = R.color.Primary)
                )
                DottedProgressBar()
            }
        }
        Spacer(modifier = Modifier.width(5.dp))
        Surface(
            modifier = Modifier
                .width(60.dp)
                .height(47.dp)
                .padding(horizontal = 5.dp),
            color = colorResource(id = R.color.white),
            shadowElevation = 5.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.microphone),
                contentDescription = "microphone",
                tint = colorResource(id = R.color.Primary),
                modifier = Modifier
                    .padding(10.dp)
                    .width(50.dp)
                    .height(37.dp)
                    .clickable {

                    }
            )
        }
    }
}

@Composable
fun TaskLevelComponent() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(63.dp),
        shadowElevation = 5.dp,
        shape = RoundedCornerShape(15.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(10.dp)
        ) {
            Surface(
                modifier = Modifier
                    .width(115.dp)
                    .height(47.dp),
                color = colorResource(id = R.color.white),
                shadowElevation = 5.dp,
                shape = RoundedCornerShape(10.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Low",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight(600),
                            color = colorResource(id = R.color.textColor),
                            letterSpacing = 0.3.sp,
                        )
                    )
                }

            }
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Medium",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(600),
                        color = colorResource(id = R.color.textColor),
                        letterSpacing = 0.3.sp,
                    )
                )
            }
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "High",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(600),
                        color = colorResource(id = R.color.textColor),
                        letterSpacing = 0.3.sp,
                    )
                )
            }

        }
    }
}

@Composable
fun TaskHeader() {
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
                    contentDescription = "Create Task",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(end = 0.dp),
                    tint = colorResource(id = R.color.red)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = " CREATE TASK",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(600),
                        color = colorResource(id = R.color.Primary),
                        letterSpacing = 0.44.sp,
                    )
                )
            }
        }
        Column {
            Row(
                modifier = Modifier.padding(0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Spacer(modifier = Modifier.width(10.dp))
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesTextField(labelValue: String) {
    var textValue by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .padding(5.dp)
            .shadow(
                elevation = 5.dp, shape = RoundedCornerShape(10.dp)
            )
            .height(200.dp)
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(size = 20.dp)
                ),
            value = textValue,
            label = {
                Text(
                    text = labelValue,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(400),
                        color = colorResource(id = R.color.textColor),
                        letterSpacing = 0.24.sp,
                    )
                )
            },
            maxLines = 5,
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = colorResource(id = R.color.white),
                placeholderColor = colorResource(id = R.color.light_gray),
                unfocusedLabelColor = colorResource(id = R.color.light_gray),
            ),
            keyboardOptions = KeyboardOptions.Default,
            shape = RoundedCornerShape(10.dp),
            /* leadingIcon = {
                 Icon(painter = painterResource,
                     contentDescription = "",
                     modifier = Modifier.size(25.dp))
             },*/
            onValueChange = {
                textValue = it
            },
        )
    }
}
