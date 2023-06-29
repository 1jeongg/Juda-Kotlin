package com.example.juda_kotlin.app.data

import java.sql.Timestamp

data class PostDTO(
    val id: String = "",
    val author: String = "",
    val content: String = "",
    val date: String = "",
    val tag1: String = "",
    val tag2: List<String> = listOf(),
    val title: String = "",
    val image: String = ""
)
