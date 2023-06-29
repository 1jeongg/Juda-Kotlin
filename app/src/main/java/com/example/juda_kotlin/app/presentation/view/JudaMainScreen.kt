package com.example.juda_kotlin.app.presentation.view

import android.view.RoundedCorner
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.presentation.component.TopJuda
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.card_gray
import com.example.juda_kotlin.ui.theme.main_gray

@Composable
fun JudaMainScreen(
    navController: NavController
){
    Box(
        modifier = Modifier.fillMaxSize()
        .background(Color.White)
    ) {
        Box {
            LazyColumn(
                modifier = Modifier.padding(top = 27.dp, start = 20.dp, end = 20.dp)
            ) {
                item { TopJuda() }
                item { SearchJuda() }
                item { MentorRecommend() }
                item { MentorItemList(onMove = { navController.navigate(Screen.DetailMentorScreen.route) }) }
                item { KeywordMentoring() }
                item { MentorItemList() }
            }
        }
        Box(
            modifier = Modifier
                .padding(17.dp)
                .background(Color.White, RoundedCornerShape(46.dp))
                .height(65.dp)
                .align(BottomCenter)
                .fillMaxWidth()
                .border(BorderStroke(0.5.dp, main_gray), RoundedCornerShape(46.dp))){
            Text(text = "A", style = TextStyles.smallText12, modifier = Modifier.align(CenterStart).padding(start = 50.dp)
                .clickable { })
            Text(text = "B", style = TextStyles.smallText12, modifier = Modifier.align(Center)
                .clickable { })
            Text(text = "C", style = TextStyles.smallText12, modifier = Modifier.align(CenterEnd).padding(end = 50.dp)
                .clickable { })
        }
    }
}

@Composable
fun KeywordMentoring() {
    Row(
        modifier = Modifier.padding(top = 46.dp, bottom = 18.dp)
    ) {
        Text(
            text = "이런 멘토 어때요?",
            style = TextStyles.textSearch,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
        )
        Text(
            text = "자세히보기",
            fontSize = 8.sp,
            color = Color(0xFF7d7d7d),
            modifier = Modifier
                .fillMaxWidth()
                .align(Bottom),
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun MentorItemList(
    onMove: () -> Unit = {}
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            MentorItem(
                onMove = onMove,
                title = "전세 사기 피하는 팁",
                description = "전직 공인중개사 윤현주의 사기 구별법",
                detail_description = "집 구하면서 나도 전세 사기 당하진 않을까 걱정한 사람 들은 이것만 명심하자.",
                tags = listOf("집 구하기", "가계부", "집 구하기")
            )
        }
        item {
            MentorItem(
                onMove = onMove,
                title = "청소, 이 루틴만 세요.",
                description = "가족들이 인정한 청소의 신을 만나다",
                detail_description = "청소는 순서만 잘 따라 오면 어렵지 않아요. .. 많은 분들이 대부분 이",
                tags = listOf("반짝반짝한 집")
            )
        }
    }
}

@Composable
fun MentorItem(
    onMove: () -> Unit = {},
    title: String = "",
    description: String = "",
    detail_description: String = "",
    tags: List<String> = emptyList()
){
    Box(
        modifier = Modifier
            .height(220.dp)
            .width(192.dp)
            .clip(RoundedCornerShape(23.dp))
            .clickable(onClick = onMove)
            .background(card_gray)
            .padding(19.dp, 16.dp)
    ){
        Column {
            Text(
                text = title,
                style = TextStyles.textSmallTitle,
                maxLines = 2,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = description,
                style = TextStyles.smallText10,
                maxLines = 2
            )
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ){
            Text(
                text = detail_description,
                style = TextStyles.smallText12,
                maxLines = 3,
                modifier = Modifier
            )
            LazyRow(
                modifier = Modifier.padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                tags.forEach {
                     item {
                        Box(
                            modifier = Modifier
                                .wrapContentWidth()
                                .clip(RoundedCornerShape(40.dp))
                                .border(
                                    border = BorderStroke(0.5.dp, main_gray),
                                    RoundedCornerShape(40.dp)
                                )
                        ) {
                            Text(
                                text = it,
                                style = TextStyles.smallText12,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(8.dp, 3.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun MentorRecommend() {
    Column(
        modifier = Modifier.padding(bottom = 17.dp)
    ){
        Text(
            text = "이런 멘토 어때요?",
            style = TextStyles.textSearch,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Row {
            Text(
                text = "관심사 기반으로 주다가 소개하는 멘토링",
                style = TextStyles.textBody
            )
            Text(
                text = "자세히보기",
                fontSize = 8.sp,
                color = Color(0xFF7d7d7d),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Bottom),
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun SearchJuda() {
    Column(
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Row {
            Text(
                text = "통합 검색",
                style = TextStyles.textSearch,
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search image",
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 12.dp)
                        .size(23.dp)
                )
            }
        }
        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp), thickness = 0.5.dp)
    }
}

