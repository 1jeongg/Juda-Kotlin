package com.example.juda_kotlin.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.juda_kotlin.R

private val Pretendard = FontFamily(
    Font(R.font.pretendard_black, FontWeight.Black), // 900
    Font(R.font.pretendard_bold, FontWeight.Bold), // 700
    Font(R.font.pretendard_light, FontWeight.Light), //300
    Font(R.font.pretendard_medium, FontWeight.Medium), // 500
    Font(R.font.pretendard_regular, FontWeight.Normal), // 400
    Font(R.font.pretendard_thin, FontWeight.Thin) // 100

)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)
object TextStyles{
    val textTitle = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = Color.Black,
    )
    val textSearch = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Color(0xFF8A8A8A),
    )
    val textSmallTitle = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color.Black,
    )
    val textBody = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Black,
    )
    val smallText12 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.Black,
    )
    val smallText10 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        color = Color.Black
    )
}