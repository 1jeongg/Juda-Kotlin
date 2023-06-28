package com.example.juda_kotlin.app.presentation.navigation

sealed class Screen(val route: String) {
    object JudaMainScreen: Screen("juda_main_screen")
}