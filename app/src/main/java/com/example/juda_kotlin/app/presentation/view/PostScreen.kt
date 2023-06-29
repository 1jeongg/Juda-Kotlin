package com.example.juda_kotlin.app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.juda_kotlin.R
import com.example.juda_kotlin.app.presentation.component.TextFieldBox
import com.example.juda_kotlin.ui.theme.TextStyles

@Composable
fun PostScreen(
    navController: NavController
){
    var title: MutableState<String> = mutableStateOf("")
    var contents: MutableState<String> = mutableStateOf("")
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "back arrow",
                modifier = Modifier.width(11.dp).clickable{navController.navigateUp()}
            )
            Text(
                text = "게시글",
                style = TextStyles.textSmallTitle,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "완료",
                style = TextStyles.textSmallTitle,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
        TextFieldBox(text = title.value, onValueChange = { title.value = it}, textStyle = TextStyles.textSearch)
        TextFieldBox(text = contents.value, onValueChange = { contents.value = it}, textStyle = TextStyles.textSmallTitle)
    }
}