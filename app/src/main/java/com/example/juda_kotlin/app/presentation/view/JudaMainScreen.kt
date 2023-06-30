package com.example.juda_kotlin.app.presentation.view

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.data.PostDTO
import com.example.juda_kotlin.app.domain.kakao_login.GlobalApplication
import com.example.juda_kotlin.app.presentation.component.DialogBoxLoading
import com.example.juda_kotlin.app.presentation.component.NavigationBar
import com.example.juda_kotlin.app.presentation.component.TopJuda
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.app.presentation.viewmodel.MentorViewModel
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.card_gray
import com.example.juda_kotlin.ui.theme.main_gray
import com.example.juda_kotlin.ui.theme.main_yellow
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@Composable
fun JudaMainScreen(
    navController: NavController,
    mentorViewModel: MentorViewModel = hiltViewModel()
){
    val tags = GlobalApplication.prefs.getString("tag2", "")
    val posts = mentorViewModel.posts
    val scaffoldState = rememberScaffoldState()
    val isRefresh by mentorViewModel.isRefresh.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefresh)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box {
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = { mentorViewModel.refreshGetSales() },
                indicator = { state, refreshTrigger ->
                    SwipeRefreshIndicator(
                        state = state,
                        refreshTriggerDistance = refreshTrigger,
                        backgroundColor = Color.White,
                        contentColor = main_yellow
                    )
                }
            ) {
                LazyColumn(
                    modifier = Modifier.padding(
                        top = 27.dp,
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 50.dp
                    )
                ) {
                    item { TopJuda() }
                    item { SearchJuda() }
                    item { MentorRecommend() }
                    item { MentorItemList(posts.shuffled(), navController) }
                    item { KeywordMentoring() }
                    item { MentorItemList(posts.shuffled(), navController) }
                    item { Spacer(modifier = Modifier.height(50.dp)) }
                }
            }
        }
        NavigationBar(Modifier.align(BottomCenter), navController = navController, true)
    }
}


@Composable
fun KeywordMentoring() {
    Row(
        modifier = Modifier.padding(top = 46.dp, bottom = 18.dp)
    ) {
        Text(
            text = "모든 키워드 멘토링",
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
    posts: List<PostDTO> = emptyList<PostDTO>(),
    navController: NavController
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        posts.forEach {
            item {
                MentorItem(
                    onMove = { navController.navigate(Screen.DetailMentorScreen.route) },
                    title = it.title,
                    description = it.content,
                    detail_description = it.content,
                    tags = it.tag2
                )
            }
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

