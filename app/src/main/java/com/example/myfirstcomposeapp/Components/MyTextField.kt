package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String) {
    var textValue by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .padding(5.dp)
            .shadow(
                elevation = 5.dp, shape = RoundedCornerShape(10.dp)

            )
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textValue,
            label = {
                Text(
                    text = labelValue,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(300),
                        color = colorResource(id = R.color.textColor),
                        letterSpacing = 0.3.sp,
                    )
                )
            },
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