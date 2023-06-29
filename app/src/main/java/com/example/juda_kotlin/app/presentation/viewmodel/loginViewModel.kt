package com.example.juda_kotlin.app.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class loginViewModel @Inject constructor(): ViewModel(){

    fun kakaoLogin(context: Context){
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
            } else if (token != null) {

            }
        }
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            Log.d("tagtag", "로그인 한대이~")
            UserApiClient.instance.loginWithKakaoTalk(context = context, callback = callback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context = context, callback =callback)
        }
    }
    private fun updateKakaoLoginUi() {
        UserApiClient.instance.me { user: User?, throwable: Throwable? ->
            if (user != null) {
                Log.d("tagtag", "ID: " + user.id)
            } else {
                Log.d("tagtag", "로그인 안됨")
            }
            null
        }
    }
}