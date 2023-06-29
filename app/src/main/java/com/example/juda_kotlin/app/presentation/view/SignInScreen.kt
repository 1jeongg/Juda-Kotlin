package com.example.juda_kotlin.app.presentation.view

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.app.presentation.viewmodel.loginViewModel

@Composable
fun SignInScreen(
    navController: NavController,
    loginViewModel: loginViewModel = hiltViewModel()
){
    val context = LocalContext.current
    Button(onClick = {
        navController.navigate(Screen.BigCategoryScreen.route)
        loginViewModel.kakaoLogin(context)
    }) {
        Text(
           text = "카카오톡으로 로그인하기",
        )
    }
}