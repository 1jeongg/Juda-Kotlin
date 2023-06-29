package com.example.juda_kotlin.app.presentation.view

import androidx.compose.foundation.*
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
import com.example.juda_kotlin.ui.theme.main_gray

@Composable
fun SmallCategoryScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
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
                    text = "완료",
                    style = TextStyles.textSearch,
                    modifier = Modifier.fillMaxWidth().align(Alignment.Center).clickable { navController.navigate(Screen.JudaMainScreen.route) },
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
            Column{
                Text(
                    text = "조금 더 자세하게 주다에게 알려주세요.",
                    style = TextStyles.textSmallTitle,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = "구체적일수록 주다가 유용할 수 있어요!",
                    style = TextStyles.textBody
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 9.dp, bottom = 57.dp), thickness = 0.5.dp
                )
                Text(
                    text = "가사/집안일",
                    style = TextStyles.textTitle,
                    modifier = Modifier.padding(bottom = 23.dp)
                )
                CategoryItem(isSelected = false, text = "집밥")
                CategoryItem(isSelected = true, text = "반짝반짝한 집")
                CategoryItem(isSelected = true, text = "집 구하기")
                CategoryItem(isSelected = false, text = "깨끗한 빨래")
                CategoryItem(isSelected = false, text = "가계부")


            }
        }

    }
}

@Composable
fun CategoryItem(
    isSelected: Boolean = false,
    text: String = ""
) {
    val textColor = if (isSelected) Color.White else Color.Black
    val btnColor = if (isSelected) Color(0xFFB5B5B5) else Color.White
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(40.dp)
            .padding(bottom = 10.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(btnColor)
            .border(BorderStroke(0.5.dp, main_gray), RoundedCornerShape(24.dp))
    ){
        Text (
            modifier = Modifier
                .padding(horizontal = 25.dp, vertical = 3.dp)
                .align(Alignment.Center),
            text = text,
            style = TextStyles.textSmallTitle,
            color = textColor,
            textAlign = TextAlign.Center,
        )
    }
}