package com.example.juda_kotlin.app.domain.kakao_login

import android.app.Application
import com.example.juda_kotlin.app.data.UserStore
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GlobalApplication: Application() {
    companion object {
        lateinit var prefs: UserStore
    }
    override fun onCreate() {
        prefs = UserStore(applicationContext)
        super.onCreate()
        KakaoSdk.init(this, "18163e5c4fbab7da2bbc5fd97307aa9e")
    }
}