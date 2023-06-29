package com.example.juda_kotlin.app.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.juda_kotlin.app.data.PostDTO
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.kakao.sdk.common.KakaoSdk.init
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.sql.Timestamp
import javax.inject.Inject

@HiltViewModel
class MentorViewModel @Inject constructor(): ViewModel() {
    private val _posts =  mutableListOf<PostDTO>()
    val posts = _posts
    private val _post = mutableStateOf<PostDTO>(PostDTO())
    val post = _post
    init {
        getPosts()
    }
    private fun getPosts(){
        val db = Firebase.firestore
        db.collection("postProvider")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    _posts.add(
                        PostDTO(
                            id = document.id,
                            author = document.data["author"].toString(),
                            content = document.data["content"].toString(),
                            date = document.data["date"].toString(),
                            tag1 = document.data["tag1"].toString(),
                            tag2 = document.data["tag2"] as List<String>,
                            title = document.data["title"].toString()
                        )
                    )
                    Log.d("tagtag", document.data["author"].toString())
                }
            }
            .addOnFailureListener {
                Log.d("tagtag", "실패함")
            }
    }
}