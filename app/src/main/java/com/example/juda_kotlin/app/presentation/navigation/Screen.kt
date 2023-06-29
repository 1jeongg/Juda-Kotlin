package com.example.juda_kotlin.app.presentation.navigation

sealed class Screen(val route: String) {
    object JudaMainScreen: Screen("juda_main_screen")
    object DetailMentorScreen: Screen("detail_mentor_screen")
    object SplashScreen: Screen("splash_screen")
    object SignInScreen: Screen("sign_in_screen")
    object BigCategoryScreen: Screen("big_category_screen")
    object SmallCategoryScreen: Screen("small_category_screen")
    object MenteeScreen: Screen("mentee_screen")
    object PostScreen: Screen("post_screen")
}