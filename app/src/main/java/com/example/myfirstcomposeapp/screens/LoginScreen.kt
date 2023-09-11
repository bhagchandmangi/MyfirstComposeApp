package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myfirstcomposeapp.Components.ButtonComponent
import com.example.myfirstcomposeapp.Components.ClickableTextComponent
import com.example.myfirstcomposeapp.Components.ClickableThiraaTextComponent
import com.example.myfirstcomposeapp.Components.HeadingTextComponent
import com.example.myfirstcomposeapp.Components.MyTextField
import com.example.myfirstcomposeapp.Components.PasswordTextField
import com.example.myfirstcomposeapp.NavigationItems
import com.example.myfirstcomposeapp.R

@Composable
fun LoginScreen(navController: NavHostController) {

    Surface (color = colorResource(id = R.color.bgcolor),
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgcolor))
            .padding(28.dp)){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.thiraa_logo1),
                contentDescription = "Contact profile picture",
                alignment = Alignment.Center,
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            ClickableThiraaTextComponent()
            Spacer(modifier = Modifier.height(20.dp))
            HeadingTextComponent(value = stringResource(id = R.string.sign_in))

                MyTextField(labelValue = stringResource(id = R.string.username))


            Spacer(modifier = Modifier.height(10.dp))

            PasswordTextField(labelValue = stringResource(id = R.string.password)
               )
            Spacer(modifier = Modifier.height(0.dp))
            ClickableTextComponent()
            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(label = stringResource(id = R.string.btn_login),  route = NavigationItems.MainNavigationScreen.route, navHostController = navController)

        }
    }
}