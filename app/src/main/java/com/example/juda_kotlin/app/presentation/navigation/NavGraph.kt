package com.example.juda_kotlin.app.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.juda_kotlin.app.presentation.view.JudaMainScreen

fun NavGraphBuilder.judaGraph(
    navController: NavController
){
    composable(route = Screen.JudaMainScreen.route) { JudaMainScreen(navController) }
}