package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BussinessCard("Muhammad Faturihsan", "Software Engineer")
                }
            }
        }
    }
}


@Composable
fun BussinessCard(name: String, job: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.realistic_white_monochrome_background_23_2149024990),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.whatsapp_image_2023_10_02_at_19_36_45),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = job,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Blue
            )
            Spacer(modifier = Modifier.padding(bottom = 100.dp))
            Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
            ContactRow(
                text = stringResource(R.string.my_phone_number),
                icon = Icons.Rounded.Phone
            )
            Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
            ContactRow(
                text = stringResource(R.string.my_account), icon = Icons.Rounded.AccountCircle
            )
            Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
            ContactRow(
                text = stringResource(R.string.my_email), icon = Icons.Rounded.Email
            )
            Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Don't Forget To Contact Me!",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier
            )


        }
    }
}


@Composable
fun ContactRow(
    text: String, icon: ImageVector, textBlur: Dp = 0.dp
) {
    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Blue,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text, color = Color.Black, modifier = Modifier
                .weight(3f)
                .blur(textBlur)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BussinessCardTheme {
        BussinessCard("Muhammad Faturihsan", "Software Engineer")
    }
}