package com.example.juda_kotlin.app.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.juda_kotlin.app.presentation.component.TopJuda
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.main_gray

@Composable
fun MenteeScreen(
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box {
            Column(
                modifier = Modifier.padding(top = 27.dp, start = 20.dp, end = 20.dp)
            ) {
                TopJuda()
                FilterItemList(listOf("반짝반짝한 집", "집 구하기", "가계부", "기타 등등"))
                MenteeItemList()
            }
        }
        Box(
            modifier = Modifier
                .padding(17.dp)
                .background(Color.White, RoundedCornerShape(46.dp))
                .height(65.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .border(BorderStroke(0.5.dp, main_gray), RoundedCornerShape(46.dp))){
            Text(text = "A", style = TextStyles.smallText12, modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 50.dp)
                .clickable { })
            Text(text = "B", style = TextStyles.smallText12, modifier = Modifier
                .align(Alignment.Center)
                .clickable { })
            Text(text = "C", style = TextStyles.smallText12, modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 50.dp)
                .clickable { })
        }
    }
}

@Composable
fun MenteeItemList() {
    LazyColumn {
        item { MenteeItem() }
        item { MenteeItem() }
        item { MenteeItem() }
        item { MenteeItem() }
        item { Spacer(modifier = Modifier.height(60.dp)) }
    }
}
@Composable
fun MenteeItem(
    title: String = "영어 잘 하시는 멘토분을 찾습니다.",
    description: String = "외국계 면접 볼 기회가 생겨 급하게 멘토분을 찾습니다",
    name: String = "김주다 · 주니어 멘티",
    date: String = "2023. 06. 29. THU"
){
    Column(
        modifier = Modifier.padding(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Divider( Modifier.padding(bottom = 24.dp))
        Text(text = title, style = TextStyles.textSearch, fontWeight = FontWeight.Medium, color = Color.Black, maxLines = 1)
        Text(text = description, style = TextStyles.textSmallTitle, maxLines = 1)
        Row{
            Text(text = name, style = TextStyles.smallText12, maxLines = 1)
            Spacer(modifier = Modifier.width(19.dp))
            Text(text = date, style = TextStyles.smallText10, maxLines = 1)
        }
    }
}

@Composable
fun FilterItemList(
    tags: List<String> = emptyList()
) {
    Column(
        modifier = Modifier.padding(top = 22.dp, bottom = 17.dp, end = 17.dp)
    ){
        Text(
            text = "멘토찾기",
            style = TextStyles.textSearch,
            color = Color.Black
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
