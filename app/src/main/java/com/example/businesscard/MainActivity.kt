package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .background(Color(0xFFd2e8d4))
            .fillMaxWidth()
    ) {
        HeroSection(Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            ContactSection()
        }
    }
}

@Composable
fun HeroSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "android logo",
            modifier = Modifier
                .padding(horizontal = 124.dp)
                .background(Color(0xFF073042)),
        )
        Text(
            text = "Jennifer Doe",
            fontSize = 36.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp),
        )
        Text(
            text = "Android Developer Extraordinaire",
            color = Color(0xFF05612c),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
            modifier = modifier.padding(bottom = 36.dp),

            ) {
            ContactItem(
                icon = Icons.Rounded.Call,
                text = "+11 (123) 444 555 666",
            )
            ContactItem(
                icon = Icons.Rounded.Share,
                text = "@AndroidDev",
                modifier = Modifier.weight(1f),
            )
            ContactItem(
                icon = Icons.Rounded.Email,
                text = "jen.doe@android.com",
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(8.dp),
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xFF05612c),
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 20.dp),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}