package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var textValue by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier
            .height(47.dp)
            .background(colorResource(id = R.color.bgcolor)),
        shape = RoundedCornerShape(50.dp),
        shadowElevation = 5.dp
    ) {

        TextField(
            value = textValue,
            onValueChange =
            {
                textValue = it
            },

            modifier = Modifier
                .fillMaxWidth(),
//            placeholder = Text(
//                text = "Search here",
//                style = TextStyle(
//                    fontSize = 15.sp,
//                    fontFamily = Poppins,
//                    fontWeight = FontWeight(300),
//                    color = Color(0xFFB3B3B6),
//                    letterSpacing = 0.3.sp,
//                )
//            ),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight(300),
                color = colorResource(id = R.color.Secondary),
                letterSpacing = 0.3.sp,
            ),
            /*leadingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },*/
            trailingIcon = {

                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(10.dp)
                            .size(40.dp)
                    )
                }
            },

            singleLine = true,
            shape = RoundedCornerShape(47.dp), // The TextFiled has rounded corners top left and right by default
            colors = TextFieldDefaults.textFieldColors(
                textColor = colorResource(id = R.color.Black),
                cursorColor = Color.Black,
                unfocusedTrailingIconColor = colorResource(id = R.color.gray),
                focusedTrailingIconColor = colorResource(id = R.color.gray),
                placeholderColor = colorResource(id = R.color.Secondary),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = colorResource(id = R.color.white),
                disabledPlaceholderColor = colorResource(id = R.color.bgcolor)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    SearchBar()
}