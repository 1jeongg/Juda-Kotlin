package com.example.juda_kotlin.app.presentation.view

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.juda_kotlin.app.presentation.navigation.Screen

@Composable
fun SignInScreen(
    navController: NavController
){
    Button(onClick = { navController.navigate(Screen.BigCategoryScreen.route)}) {
        Text(
           text = "카카오톡으로 로그인하기"
        )
    }

}