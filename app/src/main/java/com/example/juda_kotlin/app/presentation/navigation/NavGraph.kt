package com.example.juda_kotlin.app.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.juda_kotlin.app.presentation.view.*

fun NavGraphBuilder.judaGraph(
    navController: NavController
){
    composable(route = Screen.SplashScreen.route) { SplashScreen(navController) }
    composable(route = Screen.JudaMainScreen.route) { JudaMainScreen(navController) }
    composable(route = Screen.DetailMentorScreen.route) { DetailMentorScreen(navController)}
    composable(route = Screen.SignInScreen.route) { SignInScreen(navController) }
    composable(route = Screen.BigCategoryScreen.route) { BigCategoryScreen(navController)}
    composable(route = Screen.SmallCategoryScreen.route) { SmallCategoryScreen(navController) }
}