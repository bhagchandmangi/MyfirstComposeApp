package com.example.myfirstcomposeapp.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.core.widgets.Helper
import androidx.leanback.widget.Row
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.ui.theme.Poppins

@Composable
fun MessageCardviewComponent() {

    Surface(modifier = Modifier.shadow(
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp)
    )) {
        Card(
            modifier = Modifier
                .background(colorResource(id = R.color.white))
                .padding(start = 10.dp, top = 10.dp, end = 5.dp),
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
                    ProfilePictureComposable()
                    ProfileContentComposable()
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
                        fontSize = 8.sp,
                        fontFamily = Poppins,
                        color = colorResource(id = R.color.Primary)
                    )
                )
            }
        }
    }
}

@Composable
fun ProfilePictureComposable() {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = colorResource(id = R.color.white)),
        modifier = Modifier
            .size(48.dp)
            .background(colorResource(id = R.color.white))


    ) {
        Image(
            painter = painterResource(id = R.drawable.office_men),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(48.dp),
            contentDescription = "Profile picture holder"
        )
    }
}

@Composable
fun ProfileContentComposable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
            .background(colorResource(id = R.color.white)),
        verticalArrangement = Arrangement.aligned(Alignment.CenterVertically)
    ) {

        Text(text ="Catalin John",
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        )
        Text(
            text = "Hello sir, Thank for your\n" +
                    "message! we will get back to you\n" +
                    "within 24 hours...",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = Poppins,
                color = colorResource(id = R.color.TextColor)
            )

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MessageCardviewComponent()
}