package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposeapp.Components.ButtonComponent
import com.example.myfirstcomposeapp.Components.CheckBoxComponent
import com.example.myfirstcomposeapp.Components.ClickableLoginTextComponent
import com.example.myfirstcomposeapp.Components.DividerTextComponent
import com.example.myfirstcomposeapp.Components.HeadingTextComponent
import com.example.myfirstcomposeapp.Components.MyTextField
import com.example.myfirstcomposeapp.Components.NormalTextComponent
import com.example.myfirstcomposeapp.Components.PasswordTextField
import com.example.myfirstcomposeapp.R

@Composable
fun SignUpScreen() {
    val navController = rememberNavController()
    Surface(color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.CreateAccount))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(labelValue = stringResource(id = R.string.first_name)
            )
            MyTextField(
                labelValue = stringResource(id = R.string.last_name)
            )
            MyTextField(
                labelValue = stringResource(id = R.string.email)
            )
            PasswordTextField(
                labelValue = stringResource(id = R.string.password)
            )
            CheckBoxComponent()
            Spacer(modifier = Modifier.heightIn(40.dp))
            ButtonComponent(label = "Sign Up", route = "")
            Spacer(modifier = Modifier.heightIn(20.dp))
            DividerTextComponent()
            ClickableLoginTextComponent()
        }

    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}