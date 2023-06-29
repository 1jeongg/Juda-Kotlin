package com.example.juda_kotlin.app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.app.presentation.viewmodel.loginViewModel
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.main_gray
import com.example.juda_kotlin.ui.theme.main_yellow

@Composable
fun SignInScreen(
    navController: NavController,
    loginViewModel: loginViewModel = hiltViewModel()
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.small_juda),
                contentDescription = "juda",
                modifier = Modifier.height(28.dp)
            )
            Text(
                text = "환영해요!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 23.dp, bottom = 11.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "주다를 이용하시려면\n로그인해주세요.",
                style = TextStyles.textSmallTitle,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 46.dp)
            )
            Text(
                text = "간편 로그인",
                style = TextStyles.smallText12,
                color = main_gray,
                textAlign = TextAlign.Center
            )
            val context = LocalContext.current
            Button(
                modifier = Modifier.padding(top = 24.dp, bottom = 16.dp, start = 45.dp, end = 45.dp)
                    .fillMaxWidth()
                    .height(51.dp)
                    .clip(RoundedCornerShape(15.dp)),
                onClick = {
                    loginViewModel.kakaoLogin(context)
                    navController.navigate(Screen.BigCategoryScreen.route)
                },
                colors  = ButtonDefaults.buttonColors(backgroundColor = main_yellow))
            {
                Text(
                    text = "카카오톡으로 로그인하기",
                    color = Color.Black,
                    style = TextStyles.textSmallTitle
                )
            }
            Text(
                text = "카카오톡이 주다에게 회원님의 이름, 생년월일,\n프로필 사진의 기본적인 정보를 제공해요.",
                style = TextStyles.smallText12,
                color = main_gray,
                textAlign = TextAlign.Center
            )
        }

    }

}