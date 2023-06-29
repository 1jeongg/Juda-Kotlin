package com.example.juda_kotlin.app.data

data class UserDTO(
    val age: Int,
    val gender: String,
    val image: String,
    val name: String,
    val tag1: String,
    val tag2: List<String>,
    val token: String
)