package com.example.juda_kotlin.app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.ui.theme.main_gray
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
){
    LaunchedEffect(key1 = true){
        val nextScreen = Screen.JudaMainScreen
        delay(500L)
        navController.navigate(nextScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(main_gray)
    ){
        Image(
            painter = painterResource(id = R.drawable.big_juda),
            contentDescription = "juda",
            modifier = Modifier.width(200.dp).align(Alignment.Center)
        )
    }
}