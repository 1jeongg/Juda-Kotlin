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
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.juda_kotlin.app.data.PostDTO
import com.example.juda_kotlin.app.data.allCategory
import com.example.juda_kotlin.app.presentation.component.NavigationBar
import com.example.juda_kotlin.app.presentation.component.TopJuda
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.app.presentation.viewmodel.MenteeViewModel
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.main_gray
import com.example.juda_kotlin.ui.theme.main_yellow
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MenteeScreen(
    navController: NavController,
    menteeViewModel: MenteeViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    val posts = menteeViewModel.posts
    val isRefresh by menteeViewModel.isRefresh.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefresh)
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
                FilterItemList(allCategory)
                SwipeRefresh(
                    state = swipeRefreshState,
                    onRefresh = { menteeViewModel.refreshGetSales() },
                    indicator = { state, refreshTrigger ->
                        SwipeRefreshIndicator(
                            state = state,
                            refreshTriggerDistance = refreshTrigger,
                            backgroundColor = Color.White,
                            contentColor = main_yellow
                        )
                    }
                ) {
                    MenteeItemList(posts = posts, navController = navController)
                }
            }
        }
        NavigationBar(Modifier.align(Alignment.BottomCenter), navController = navController, false)
    }
}

@Composable
fun MenteeItemList(
    posts: List<PostDTO> = emptyList(),
    navController: NavController
) {
    LazyColumn {
        posts.forEach {
            item { MenteeItem(
                onClick = {navController.navigate(Screen.DetailMentorScreen.route)},
                title = it.title,
                description = it.content,
                name = it.content,
                date = it.date
            ) }
        }
        item { Spacer(modifier = Modifier.height(60.dp)) }
    }
}
@Composable
fun MenteeItem(
    onClick: () -> Unit = {},
    title: String = "영어 잘 하시는 멘토분을 찾습니다.",
    description: String = "외국계 면접 볼 기회가 생겨 급하게 멘토분을 찾습니다",
    name: String = "김주다 · 주니어 멘티",
    date: String = "2023. 06. 29. THU"
){
    Column(
        modifier = Modifier.padding(bottom = 24.dp).clickable(onClick = onClick),
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
