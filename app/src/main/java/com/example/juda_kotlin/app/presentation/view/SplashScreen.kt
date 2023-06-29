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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.app.presentation.viewmodel.loginViewModel
import com.example.juda_kotlin.ui.theme.main_gray
import com.example.juda_kotlin.ui.theme.main_yellow
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    loginViewModel: loginViewModel = hiltViewModel()
){
    LaunchedEffect(key1 = true){
        val nextScreen = if (loginViewModel.isLogIn()) Screen.JudaMainScreen else Screen.SignInScreen
        delay(1000L)
        navController.popBackStack()
        navController.navigate(nextScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(main_yellow, Color(0xFFFBEED5))))
    ){
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = "juda",
            modifier = Modifier.width(200.dp).align(Alignment.Center)
        )
    }
}