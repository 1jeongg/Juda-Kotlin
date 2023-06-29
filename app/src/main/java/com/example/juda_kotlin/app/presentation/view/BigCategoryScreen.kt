package com.example.juda_kotlin.app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.ui.theme.TextStyles

@Composable
fun BigCategoryScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ){
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "back arrow",
            modifier = Modifier
                .padding(22.dp)
                .width(11.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(40.dp, 40.dp))
                .background(Color.White)
                .padding(20.dp, 30.dp)) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(45.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .clickable(onClick = { navController.navigate(Screen.SmallCategoryScreen.route) })
                    .background(Color(0xFFEAEAEA))
            ){
                Text(
                    text = "다음",
                    style = TextStyles.textSearch,
                    modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
            Column{
                Text(
                    text = "지금 관심있는 주제가 있나요?",
                    style = TextStyles.textTitle,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = "주다에서 관심사 기반으로 멘토를 추천해줘요.",
                    style = TextStyles.textBody
                )
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 9.dp, bottom = 25.dp), thickness = 0.5.dp)
                SelectTopic()
                SelectTopic(id = R.drawable.sport, text = "운동")
                SelectTopic(
                    id = R.drawable.houses,
                    text = "가사/집안일"
                )
                }
            }
    }

}

@Composable
fun SelectTopic(
    onClick: () -> Unit = {},
    id: Int = R.drawable.future,
    text: String = "취업/진로"
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(137.dp)
            .clip(RoundedCornerShape(21.dp))
            .padding(bottom = 14.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = id),
            contentDescription = ""
        )
        Text(
            text = text,
            style = TextStyles.textTitle,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 20.dp, bottom = 10.dp)
        )
    }
}