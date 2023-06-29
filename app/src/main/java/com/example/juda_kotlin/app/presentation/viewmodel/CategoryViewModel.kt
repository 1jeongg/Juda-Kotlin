package com.example.juda_kotlin.app.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.juda_kotlin.app.data.BigCategory
import com.example.juda_kotlin.app.data.SmallCategory
import com.example.juda_kotlin.app.domain.kakao_login.GlobalApplication
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(): ViewModel() {
    private val categories = mutableStateOf("")

    fun makeUserByFireBase(){
        val ageRange = GlobalApplication.prefs.getString("age", "AGE_20_30")
        val nickname = GlobalApplication.prefs.getString("nickname", "user")
        val gender = GlobalApplication.prefs.getString("gender", "null")
        val imageUrl = GlobalApplication.prefs.getString("image", "null")
        val tag1 = GlobalApplication.prefs.getString("tag1", "null")
        val tag2 = GlobalApplication.prefs.getString("tag2", "null")
        val token = GlobalApplication.prefs.getString("token", "null")

        val db = Firebase.firestore
        val myData = hashMapOf(
            "age" to ageRange.slice(4..5),
            "name" to nickname,
            "gender" to gender,
            "image" to imageUrl,
            "tag1" to tag1,
            "tag2" to tag2.split(" ").filter{it.isNotBlank()}
        )
        try {
            db.collection("user").document(token)
                .set(myData)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("tagtag", "유저 저장 성공~")
                    } else {
                        Log.d("tagtag", "유저 저장 실패..")
                    }
                }
        } catch(e: Exception) {
            Log.d("tagtag", e.message.toString())
            e.printStackTrace()
        }
    }

    fun addSmallCategory(index: Int, category: Int) {
        categories.value += SmallCategory[index][category] + " "
        GlobalApplication.prefs.setString("tag1", BigCategory[index])
        GlobalApplication.prefs.setString("tag2", categories.value)
    }

}