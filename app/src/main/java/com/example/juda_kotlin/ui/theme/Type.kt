package com.example.juda_kotlin.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
object TextStyles{
    val textTitle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = Color.Black,
    )
    val textSearch = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Color(0xFF8A8A8A),
    )
    val textSmallTitle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color.Black,
    )
    val textBody = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Black,
    )
    val smallText12 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.Black,
    )
    val smallText10 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        color = Color.Black
    )
}