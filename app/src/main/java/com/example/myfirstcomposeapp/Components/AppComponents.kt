package com.example.myfirstcomposeapp.Components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Serif
        ),
        color = colorResource(id = R.color.TextColor),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 25.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight(600),
            color = Color(0xFF1E6233),
            letterSpacing = 0.5.sp,
        ),
        color = colorResource(id = R.color.Primary),
        textAlign = TextAlign.Start,
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue: String) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember {
        mutableStateOf(
            false
        )
    }

    Surface(
        modifier = Modifier
            .padding(5.dp)
            .shadow(
                elevation = 5.dp, shape = RoundedCornerShape(10.dp)

            )
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            label = {
                Text(
                    text = labelValue,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(300),
                        color = Color(0xFFB3B3B6),
                        letterSpacing = 0.3.sp,
                    )
                )
            },
            colors = TextFieldDefaults.textFieldColors(

                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                placeholderColor = colorResource(id = R.color.light_gray),
                unfocusedLabelColor = colorResource(id = R.color.light_gray),
                containerColor = colorResource(id = R.color.white)
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(5.dp),
            onValueChange = {
                password = it
            },
            /* leadingIcon = {
                 Icon(painter = painterResource,
                     contentDescription = "",
                     modifier = Modifier.size(25.dp))
             },*/
            trailingIcon = {
                val iconImage = if (passwordVisible) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                }
                var description = if (passwordVisible) {
                    stringResource(id = R.string.hide_password)
                } else {
                    stringResource(id = R.string.show_password)
                }
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = iconImage, contentDescription = description,
                        tint = colorResource(id = R.color.light_gray)
                    )
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

            )

    }
}

@Composable
fun CheckBoxComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState by remember { mutableStateOf(false) }
        Checkbox(checked = checkedState, onCheckedChange = {
            checkedState != checkedState
        })
        ClickableTextComponent()
    }
}

@Composable
fun ClickableTextComponent() {
    val initialText = "By Signing up you agree to our"
    val privacyPolicy = " Terms & Conditions"
    val andText = " and "
    val termsAndCondition = " Privacy Policy"
    val annotatedString = buildAnnotatedString {

        withStyle(style = SpanStyle(colorResource(id = R.color.light_gray))) {
            pushStringAnnotation(tag = initialText, annotation = initialText)
            append(initialText)
        }
        withStyle(style = SpanStyle(colorResource(id = R.color.Primary))) {
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }
        withStyle(style = SpanStyle(colorResource(id = R.color.light_gray))) {
            pushStringAnnotation(tag = andText, annotation = andText)
            append(andText)
        }
        withStyle(style = SpanStyle(colorResource(id = R.color.Primary))) {
            pushStringAnnotation(tag = termsAndCondition, annotation = termsAndCondition)
            append(termsAndCondition)
        }
    }
    ClickableText(
        text = annotatedString, onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")
            }
        }, modifier = Modifier.padding(20.dp)
    )
}


@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(id = R.color.GrayColor),
            thickness = 1.dp
        )
        Text(
            text = stringResource(id = R.string.or),
            modifier = Modifier.padding(8.dp),
            fontSize = 14.sp,
            color = colorResource(id = R.color.TextColor)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(id = R.color.GrayColor),
            thickness = 1.dp
        )
    }
}

@Composable
fun ClickableLoginTextComponent() {
    val initialText = "Already have an account?"
    val LoginText = " Login "
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(colorResource(id = R.color.Primary))) {
            pushStringAnnotation(tag = LoginText, annotation = LoginText)
            append(LoginText)
        }

    }
    ClickableText(text = annotatedString,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")
            }
        })
}

@Composable
fun ClickableThiraaTextComponent() {
    val initialText = "Welcome to "
    val ThiraaText = " Thiraa "
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(
            style = SpanStyle(
                colorResource(id = R.color.red),
                fontSize = 18.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight(600),
                letterSpacing = 5.4.sp,
            )
        ) {
            pushStringAnnotation(tag = ThiraaText, annotation = ThiraaText)
            append(ThiraaText)
        }

    }
    ClickableText(text = annotatedString,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")
            }
        })
}







