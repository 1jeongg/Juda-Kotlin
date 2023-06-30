package com.example.juda_kotlin.app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.data.PostDTO
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.main_gray
import com.example.juda_kotlin.ui.theme.main_yellow

@Composable
fun DetailMentorScreen(
    navController: NavController,
){
    var isOpen by remember { mutableStateOf(false) }
    var isAgree by remember { mutableStateOf(false) }
    PopUpScreen(
        isOpen = isOpen,
        onDismiss = { isOpen = !isOpen },
        onAgree = {navController.navigate(Screen.SuccessMatchScreen.route)}
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp)
    ){
        DetailButton(
            onRegister = { isOpen = true },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(22.dp)
    ) {
        item { DetailTopBar(onClick = {navController.navigateUp()}) }
        item { UserProfile() }
        item { DetailTitle() }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.empty),
                    contentDescription = "empty mentee",
                    modifier = Modifier
                        .width(141.dp)
                        .align(Center)
                )
            }
        }
    }
}

@Composable
fun PopUpScreen(
    isOpen: Boolean,
    onDismiss: () -> Unit = {},
    onAgree: () -> Unit = {}
) {
    if (isOpen) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties()
        ) {
            Box(
                modifier = Modifier
                    .padding(20.dp, 20.dp, 20.dp, 0.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(bottom = 20.dp)
                ) {
                    Text(
                        text = "잠깐",
                        style = TextStyles.textBody,
                        modifier = Modifier
                            .padding(top = 17.dp, bottom = 18.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "정말 윤현주님의 ‘전세 사기 피하는 팁' 멘토링을 신청하시겠어요?",
                        style = TextStyles.textSmallTitle,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(26.dp, 0.dp, 26.dp, 50.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
                Row(
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                        .align(BottomCenter),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        Modifier
                            .weight(1f)
                            .clickable(onClick = onAgree)
                            .background(main_yellow)){
                        Text(
                            text = "네, 신청할래요.",
                            style = TextStyles.textBody,
                            modifier = Modifier
                                .align(Center)
                                .fillMaxSize()
                                .padding(vertical = 10.dp),
                            textAlign = TextAlign.Center,
                        )
                    }
                    Box(
                        Modifier
                            .weight(1f)
                            .clickable(onClick = onDismiss)
                            .background(Color(0xFFEFEFEF))) {
                        Text(
                            text = "아니요.",
                            style = TextStyles.textBody,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Center)
                                .fillMaxSize()
                                .padding(vertical = 10.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DetailButton(
    onRegister: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Box(
            modifier = Modifier
                .weight(2f)
                .height(65.dp)
                .border(width = 0.5.dp, color = main_gray, shape = RoundedCornerShape(46.dp))
                .clip(RoundedCornerShape(46.dp))
                .background(main_yellow)
                .clickable(onClick = onRegister),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "신청하기",
                style = TextStyles.textSmallTitle,
                textAlign = TextAlign.Center,
            )
        }
        Box(
           modifier = Modifier
               .weight(1f)
               .height(65.dp)
               .border(width = 0.5.dp, color = main_gray, shape = RoundedCornerShape(46.dp))
               .clip(RoundedCornerShape(46.dp))
               .background(Color(0xFFF5F5F5)),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "문의",
                style = TextStyles.textSmallTitle,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DetailTitle(
    title: String = "전세 사기 피하는 팁",
    date: String = "2023. 06. 29. THU",
    content: String = """집 구하면서 나도 전세 사기 당하진 않을까 걱정한 사람들은 이것만 명심하자.
        
안녕하세요? 전직 공인중개사 시니어 멘토 윤현주 입니다. 집 구하실 때 고민이 많으셨을거에요. 20년 동안 공인중개사에 몸을 담그며 얻은 노하우를 여러 분께 전수해드리려고 합니다. 
        
실제로 집을 찾고 계신 분들도 환영이에요^^""".trimMargin()
) {
    Column(){
        Text(
            text = title,
            style = TextStyles.textTitle
        )
        Text(
            text = date,
            style = TextStyles.smallText10
        )
        Text(
            text = content,
            style = TextStyles.textSmallTitle,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(vertical = 20.dp)
        )
    }
}

@Composable
fun UserProfile(
    post: PostDTO = PostDTO()
) {
    Row(modifier = Modifier.padding(bottom = 30.dp)){

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.size(38.dp)
            .padding(end = 13.dp)
            .clip(CircleShape)
        )
        Column {
            Text(
                text = "원정이",
                style = TextStyles.textSmallTitle,
            )
            Text(
                text = "시니어 멘토",
                style = TextStyles.smallText12,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
fun DetailTopBar(
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "back arrow",
            modifier = Modifier
                .width(11.dp)
                .clickable(onClick = onClick)
        )
        Text(
            text = "게시글",
            style = TextStyles.textSmallTitle,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}
