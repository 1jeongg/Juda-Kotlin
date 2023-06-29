package com.example.juda_kotlin.app.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.juda_kotlin.app.presentation.view.DetailMentorScreen
import com.example.juda_kotlin.app.presentation.view.JudaMainScreen
import com.example.juda_kotlin.app.presentation.view.SplashScreen

fun NavGraphBuilder.judaGraph(
    navController: NavController
){
    composable(route = Screen.SplashScreen.route) { SplashScreen(navController) }
    composable(route = Screen.JudaMainScreen.route) { JudaMainScreen(navController) }
    composable(route = Screen.DetailMentorScreen.route) { DetailMentorScreen(navController)}
}