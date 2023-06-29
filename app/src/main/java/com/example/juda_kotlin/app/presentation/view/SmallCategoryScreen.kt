package com.example.juda_kotlin.app.presentation.view

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.data.BigCategory
import com.example.juda_kotlin.app.data.SmallCategory
import com.example.juda_kotlin.app.presentation.navigation.Screen
import com.example.juda_kotlin.app.presentation.viewmodel.CategoryViewModel
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.main_gray
import com.example.juda_kotlin.ui.theme.main_yellow

@Composable
fun SmallCategoryScreen(
    navController: NavController,
    index: Int,
    categoryViewModel: CategoryViewModel = hiltViewModel()
) {
    val isSelected  = remember { listOf(mutableStateOf(false), mutableStateOf(false), mutableStateOf(false),
        mutableStateOf(false), mutableStateOf(false), mutableStateOf(false)) }
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
                .clickable { navController.navigateUp() }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(40.dp, 40.dp))
                .background(Color.White)
                .padding(20.dp, 30.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(45.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .clickable {
                        categoryViewModel.makeUserByFireBase()
                        navController.navigate(Screen.JudaMainScreen.route)
                    }
                    .background(main_yellow)
            ){
                Text(
                    text = "완료",
                    style = TextStyles.textSearch,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
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
                    text = BigCategory[index],
                    style = TextStyles.textTitle,
                    modifier = Modifier.padding(bottom = 23.dp)
                )
                SmallCategory[index].forEachIndexed { a, it ->
                    CategoryItem(
                        isSelected = isSelected[a].value,
                        text = it,
                        onClick = {
                            categoryViewModel.addSmallCategory(index, a)
                            isSelected[a].value = !isSelected[a].value
                        })
                }
                Spacer(modifier = Modifier.height(80.dp))
            }
        }

    }
}

@Composable
fun CategoryItem(
    onClick: () -> Unit = {},
    isSelected: Boolean = false,
    text: String = ""
) {
    val textColor = if (isSelected) Color.White else Color.Black
    val btnColor = if (isSelected) main_yellow else Color.White
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(40.dp)
            .padding(bottom = 10.dp)
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = onClick)
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