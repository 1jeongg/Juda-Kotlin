package com.example.juda_kotlin.app.presentation.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.data.PostDTO
import com.example.juda_kotlin.app.presentation.viewmodel.MentorViewModel
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.main_gray
import com.example.juda_kotlin.ui.theme.main_yellow

@Composable
fun DetailMentorScreen(
    navController: NavController,
    mentorViewModel: MentorViewModel = hiltViewModel(),
    index: String = ""
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp)
    ){
        DetailButton(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp)
    ) {
        item { DetailTopBar(onClick = {navController.navigateUp()}) }
        item { UserProfile() }
        item { DetailTitle() }
    }
}

@Composable
fun DetailButton(
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
                .background(main_yellow),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "신청하기",
                style = TextStyles.textSmallTitle,
                textAlign = TextAlign.Center
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
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://k.kakaocdn.net/dn/KeUb5/btr6EUTjP33/mkPVnUVKkmO4tpI5JbBqr0/img_640x640.jpghttps://k.kakaocdn.net/dn/KeUb5/btr6EUTjP33/mkPVnUVKkmO4tpI5JbBqr0/img_640x640.jpg")
                .crossfade(true)
                .build(),
            contentDescription = null,
            placeholder = painterResource(R.drawable.small_juda),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(38.dp)
                .padding(end = 13.dp)
                .clip(CircleShape),
            alignment = Alignment.Center
        )
        Column {
            Text(
                text = post.author,
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
            modifier = Modifier.width(11.dp).clickable(onClick = onClick)
        )
        Text(
            text = "게시글",
            style = TextStyles.textSmallTitle,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}
