package com.example.juda_kotlin.app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.juda_kotlin.R

@Composable
fun ChattingScreen(
    navController: NavController
){
    /*
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "back arrow",
                    modifier = Modifier
                        .padding(22.dp)
                        .width(11.dp)
                        .clickable { navController.navigateUp() }
                )
                UserProfile(name = "윤현주", role = "시니어 멘토")
            }

        }
    }*/
    Image(
        painter = painterResource(id = R.drawable.chatting),
        contentDescription = "chatting",
        modifier = Modifier.fillMaxSize()
    )
}