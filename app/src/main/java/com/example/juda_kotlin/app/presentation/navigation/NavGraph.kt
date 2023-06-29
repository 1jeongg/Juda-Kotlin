package com.example.juda_kotlin.app.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.juda_kotlin.app.presentation.view.*

fun NavGraphBuilder.judaGraph(
    navController: NavController
){
    composable(route = Screen.SplashScreen.route) { SplashScreen(navController) }
    composable(route = Screen.JudaMainScreen.route) { JudaMainScreen(navController) }
    composable(
        route = Screen.DetailMentorScreen.route + "/{id}",
        arguments = listOf(navArgument("id") { type = NavType.StringType} )
    ) {
        val id = it.arguments?.getString("id") ?: ""
        DetailMentorScreen(navController, index = id)
    }
    composable(route = Screen.SignInScreen.route) { SignInScreen(navController) }
    composable(route = Screen.BigCategoryScreen.route) { BigCategoryScreen(navController)}
    composable(route = Screen.SmallCategoryScreen.route + "/{index}",
        arguments = listOf(navArgument("index"){type = NavType.IntType})) {
        val id = it.arguments?.getInt("index") ?: 0
        SmallCategoryScreen(navController, id)
    }
    composable(route = Screen.MenteeScreen.route) { MenteeScreen(navController) }
    composable(route = Screen.PostScreen.route) { PostScreen(navController)}
}