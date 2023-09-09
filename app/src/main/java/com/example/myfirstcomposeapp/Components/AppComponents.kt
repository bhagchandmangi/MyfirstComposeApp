package com.example.myfirstcomposeapp.Components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import androidx.compose.ui.tooling.preview.Preview
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
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontFamily = Poppins,
        ),
        color = colorResource(id = R.color.Primary),
        textAlign = TextAlign.Start,
    )
}

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
            label = { Text(text = labelValue) },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = colorResource(id = R.color.white),
                placeholderColor = colorResource(id = R.color.gray),
                unfocusedLabelColor = colorResource(id = R.color.gray),
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
            label = { Text(text = labelValue) },
            colors = TextFieldDefaults.textFieldColors(

                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                placeholderColor = colorResource(id = R.color.gray),
                unfocusedLabelColor = colorResource(id = R.color.gray),
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
                    Icon(imageVector = iconImage, contentDescription = description)
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

        withStyle(style = SpanStyle(colorResource(id = R.color.gray))) {
            pushStringAnnotation(tag = initialText, annotation = initialText)
            append(initialText)
        }
        withStyle(style = SpanStyle(colorResource(id = R.color.Primary))) {
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }
        withStyle(style = SpanStyle(colorResource(id = R.color.gray))) {
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
        withStyle(style = SpanStyle(colorResource(id = R.color.red))) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShadowedTextField() {
    var text by remember { mutableStateOf("") }

    Box(modifier = Modifier.run {
        padding(16.dp)
            .shadow(
                elevation = 4.dp,
                shape = RectangleShape,

                )
            .offset(2.dp, 3.dp)
            .alpha(.5f)
    }) {
        TextField(value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Enter text") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.welcome),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    fontFamily = Poppins,
                ),
            )
        }, colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.bgcolor),
            titleContentColor = colorResource(id = R.color.Primary)
        )
    )

}

@Composable
fun Rowcomponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
        ) {
            OutlinedButton(
                onClick = { /* Handle button click here */ },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = colorResource(id = R.color.Primary),
                    contentColor = colorResource(id = R.color.white)
                )
            ) {
                // Button text
                Text(
                    text = "Task in Progress", style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.2.sp,
                    )
                )
            }
        }

        Column(
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {


                    OutlinedButton(
                        onClick = { /* Handle button click here */ },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = colorResource(id = R.color.Primary),
                            contentColor = colorResource(id = R.color.white)
                        )
                    ) {
                        // Button text
                        Text(
                            text = "Task in Progress", style = TextStyle(
                                fontSize = 10.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF),
                                letterSpacing = 0.2.sp,
                            )
                        )
                    }
                    OutlinedButton(
                        onClick = { /* Handle button click here */ },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = colorResource(id = R.color.Primary),
                            contentColor = colorResource(id = R.color.white)
                        )
                    ) {
                        // Button text
                        Text(
                            text = "Task in Progress", style = TextStyle(
                                fontSize = 10.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF),
                                letterSpacing = 0.2.sp,
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                Icon(
                    painter = painterResource(
                        id = R.drawable.hamburger
                    ),
                    contentDescription = null,

                    )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun RowcomponentPreview() {
//    Rowcomponent()
//}

@Composable
fun CustomRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.bgcolor)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.padding(start = 5.dp))
        {
            CustomButton(
                text = "Task in Progress",
                colorResource(id = R.color.Primary),
                contentColor = colorResource(R.color.white)
            )

        }

        Spacer(modifier = Modifier.width(24.dp)) // Add two times more space between the first component and others

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                com.example.myfirstcomposeapp.screens.CustomButton(
                    text = "Assigned",
                    backgroundColor = colorResource(id = R.color.Primary),
                    contentColor = colorResource(R.color.Primary)
                )

                Spacer(modifier = Modifier.width(8.dp)) // Add spacing between buttons

                com.example.myfirstcomposeapp.screens.CustomButton(
                    text = "Created",
                    backgroundColor = colorResource(id = R.color.Primary),
                    contentColor = colorResource(R.color.white)
                )

                Spacer(modifier = Modifier.width(8.dp)) // Add spacing between buttons

                // Third Column with hamburger icon
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.pepicons_pop_menu),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun CustomButton(text: String, backgroundColor: Color, contentColor: Color, ) {
    androidx.compose.material3.Button(
        onClick = { /* Handle button click here */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ), shape = RoundedCornerShape(5.dp),
        modifier = Modifier.shadow(elevation = 5.dp)
            .padding(0.dp)

    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.2.sp,
            ),
            modifier = Modifier.padding(0.dp)
        )
    }
}


@Preview
@Composable
fun CustomRowPreview() {
    CustomRow()
}






