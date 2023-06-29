package com.example.juda_kotlin.app.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.juda_kotlin.app.data.PostDTO
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenteeViewModel @Inject constructor(): ViewModel() {
    private val _posts = mutableListOf<PostDTO>()
    val posts = _posts

    init {
        getPosts()
    }

    fun getPosts(){
        val db = Firebase.firestore
        db.collection("postRequest")
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