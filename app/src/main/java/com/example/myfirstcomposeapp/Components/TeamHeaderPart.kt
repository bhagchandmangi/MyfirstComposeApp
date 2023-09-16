package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@Composable
fun TeamHeaderPart() {
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
                    painter = painterResource(id = R.drawable.team),
                    contentDescription = "Team",
                    modifier = Modifier
                        .size(17.dp)
                        .padding(end = 0.dp),
                    tint = colorResource(id = R.color.red)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Team",
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.Primary),
                        fontSize = 22.sp
                    ),
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
