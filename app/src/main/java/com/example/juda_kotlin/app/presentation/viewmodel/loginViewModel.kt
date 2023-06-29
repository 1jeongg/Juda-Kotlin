package com.example.juda_kotlin.app.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.juda_kotlin.app.domain.kakao_login.GlobalApplication
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
    private val myToken = GlobalApplication.prefs.getString("token", "")
    fun isLogIn(): Boolean{
        return myToken.isNotBlank()
    }
    fun kakaoLogin(context: Context){
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
            } else if (token != null) {
                GlobalApplication.prefs.setString("token", token.accessToken)
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
                GlobalApplication.prefs.setString("image", user.kakaoAccount?.profile?.profileImageUrl ?: "")
                GlobalApplication.prefs.setString("nickname", user.kakaoAccount?.profile?.nickname ?: "user")
                GlobalApplication.prefs.setString("gender", user.kakaoAccount?.gender?.name ?: "female")
                GlobalApplication.prefs.setString("age", user.kakaoAccount?.ageRange?.name ?: "AGE_20_29")
                Log.d("tagtag", GlobalApplication.prefs.getString("nickname", "user"))
            } else {
                Log.d("tagtag", "로그인 안됨")
            }
        }
    }
}