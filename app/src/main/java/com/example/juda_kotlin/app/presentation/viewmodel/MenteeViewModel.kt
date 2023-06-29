package com.example.juda_kotlin.app.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.juda_kotlin.app.data.PostDTO
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenteeViewModel @Inject constructor(): ViewModel() {
    private val _posts = mutableListOf<PostDTO>()
    val posts = _posts

    init {
        getPosts()
    }
    fun getPost(id: String): PostDTO{
        val db = Firebase.firestore
        var post =  PostDTO()
        db.collection("postRequest")
            .document(id)
            .get()
            .addOnSuccessListener { result ->
                post = PostDTO(
                    id = result.id,
                    author = result.data?.get("author").toString(),
                    content = result.data?.get("author").toString(),
                    date = result.data?.get("author").toString(),
                    tag1 = result.data?.get("author").toString(),
                    tag2 = result.data?.get("tag2") as List<String>,
                    title = result.data?.get("title").toString()
                )
            }
            .addOnFailureListener {
                Log.d("tagtag", "실패함")
            }
        return post
    }
    fun getPosts(){
        val db = Firebase.firestore
        db.collection("postRequest")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    posts.add(
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
                }
            }
            .addOnFailureListener {
                Log.d("tagtag", "실패함")
            }
    }
}