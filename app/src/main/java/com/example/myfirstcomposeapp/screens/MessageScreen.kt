package com.example.myfirstcomposeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposeapp.Components.CountryList
import com.example.myfirstcomposeapp.Components.MessageCardviewComponent
import com.example.myfirstcomposeapp.Components.MessageHeaderPart
import com.example.myfirstcomposeapp.Components.SearchBar
import com.example.myfirstcomposeapp.NavigationItem.Message.icon
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@Composable
fun MessageScreen() {
    Surface (color = colorResource(id = R.color.bgcolor),
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgcolor))
            .padding(20.dp)){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(20.dp))

            MessageHeaderPart()
            Spacer(modifier = Modifier.height(20.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(20.dp))
            MessageCardviewComponent()
            Spacer(modifier = Modifier.height(20.dp))
            MessageCardviewComponent()
            Spacer(modifier = Modifier.height(20.dp))
            MessageCardviewComponent()

        }
}
}

@Preview(showBackground = true)
@Composable
fun MessageScreenPreview() {
    MessageScreen()
}