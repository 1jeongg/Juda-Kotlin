package com.example.juda_kotlin.app.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class loginViewModel @Inject constructor(): ViewModel(){
    var myToken = mutableStateOf("")
    var gender = mutableStateOf("")
    var ageRange = mutableStateOf("")
    var nickname = mutableStateOf("")
    var imageUrl = mutableStateOf("")
    var big_category = mutableStateOf(0)
    var small_category = mutableListOf<Int>()

    fun isLogIn(): Boolean{
        return myToken.value.isNullOrBlank()
    }
    fun setBigCategory(index: Int){
        big_category.value = index
    }
    fun addSmallCategory(index:Int){
        small_category.add(index)
    }
    fun test(){
        Log.d("tagtag", "My token: " + myToken.value)
        //makeUserByFireBase()
    }
    fun kakaoLogin(context: Context){
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
            } else if (token != null) {
                myToken.value = token.accessToken
                updateKakaoLoginUi()
            }
        }
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context = context, callback = callback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context = context, callback =callback)
        }
    }
    private fun updateKakaoLoginUi() {
        UserApiClient.instance.me { user: User?, throwable: Throwable? ->
            if (user != null) {
                imageUrl.value = user.kakaoAccount?.profile?.profileImageUrl ?: "none"
                Log.d("tagtag", imageUrl.value)
                nickname.value = user.kakaoAccount?.profile?.nickname ?: "user"
                Log.d("tagtag", nickname.value)
                gender.value = user.kakaoAccount?.gender?.name ?: "female"
                Log.d("tagtag", gender.value)
                ageRange.value = user.kakaoAccount?.ageRange?.name ?: "AGE_20_29"
                Log.d("tagtag", ageRange.value)
            } else {
                Log.d("tagtag", "로그인 안됨")
            }
            null
        }
    }
    private fun makeUserByFireBase(){
        val db = Firebase.firestore
        val myData = hashMapOf(
            "age" to ageRange.value.slice(4..5),
            "name" to nickname.value,
            "gender" to gender.value,
            "image" to imageUrl.value,
            "tag1" to "hello",
            "tag2" to arrayOf(0,1,2)
        )
        try {
            db.collection("user").document(myToken.value)
                .set(myData)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("tagtag", "성공~")
                    } else {
                        Log.d("tagtag", "실패..")
                    }
                }
        } catch(e: Exception) {
            Log.d("tagtag", e.message.toString())
            e.printStackTrace()
        }
    }
}