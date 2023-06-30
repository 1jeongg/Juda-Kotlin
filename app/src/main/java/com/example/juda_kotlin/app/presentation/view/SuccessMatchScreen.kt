package com.example.juda_kotlin.app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.main_yellow

@Composable
fun SuccessMatchScreen(
    navController: NavController
){
    Box(
        modifier = Modifier.background(brush = Brush.verticalGradient(colors = listOf(main_yellow, Color(0xFFFBEED5)))).fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.break_egg),
            contentDescription = "break eggs" ,
            modifier = Modifier.fillMaxSize().padding(bottom = 80.dp)
        )
        Column(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "매칭 성공!",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "윤현주님과의 ‘전세 사기 피하는 팁'\n멘토링이 매칭되었어요.",
                style = TextStyles.textSmallTitle,
                color = Color.Black,
                modifier = Modifier.padding(top = 20.dp, bottom = 13.dp).fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "윤현주님과 앞으로 한 걸음 더 떼보아요!",
                style = TextStyles.textSmallTitle,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(45.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .clickable {
                        navController.navigate(Screen.JudaMainScreen.route)
                    }
                    .background(main_yellow)
            ){
                Text(
                    text = "완료",
                    style = TextStyles.textSearch,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }

    }

}