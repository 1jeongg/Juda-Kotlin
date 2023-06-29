package com.example.juda_kotlin.app.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.juda_kotlin.R

@Composable
fun TopJuda(){
    Image(
        painter = painterResource(id = R.drawable.small_juda),
        contentDescription = "juda image",
        modifier = Modifier.height(20.dp)
    )
}