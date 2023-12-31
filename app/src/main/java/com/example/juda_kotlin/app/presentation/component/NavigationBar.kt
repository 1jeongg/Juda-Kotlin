package com.example.juda_kotlin.app.presentation.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.main_gray

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    isLocation: Boolean = true
){

    Column(
        modifier = modifier.padding(17.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.post),
            contentDescription = "post",
            modifier = Modifier
                .size(65.dp)
                .clickable { }
                .padding(bottom = 17.dp)
                .align(Alignment.End)
                .clickable{ navController.navigate(Screen.PostScreen.route) }
        )
        Box(
            modifier = Modifier
                .shadow(2.dp, RoundedCornerShape(30.dp))
                .height(65.dp)
                .background(Color.White, RoundedCornerShape(46.dp))
                .fillMaxWidth()
                .border(BorderStroke(0.5.dp, main_gray), RoundedCornerShape(46.dp))
        ) {
            Column(
                modifier = Modifier.align(Alignment.CenterStart)
                    .padding(start = 50.dp)
                    .clickable { navController.navigate(Screen.MenteeScreen.route);  },
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = if(isLocation) R.drawable.location else R.drawable.location_yes),
                    contentDescription = "location navigate",
                    modifier = Modifier.size(26.dp)
                )
                Text(text = "멘토찾기", style = TextStyles.smallText12, color = if(isLocation) Color(0xFF969696) else Color.Black)
            }
            Column(
                modifier = Modifier.align(Alignment.Center)
                    .clickable { navController.navigate(Screen.JudaMainScreen.route)},
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = if(isLocation) R.drawable.home else R.drawable.home_no),
                    contentDescription = "home navigate",
                    modifier = Modifier.size(26.dp)
                )
                Text(text = "메인", style = TextStyles.smallText12, color = if(isLocation) Color.Black else Color(0xFF969696))
            }
            Column(
                modifier = Modifier.align(Alignment.CenterEnd)
                    .padding(end = 50.dp)
                    .clickable { },
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "mypage navigate",
                    modifier = Modifier.size(26.dp)
                )
                Text(text = "마이페이지", style = TextStyles.smallText12, color = Color(0xFF969696))
            }
        }
    }
}