package com.example.juda_kotlin.app.domain.kakao_login

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GlobalApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "757111a2ccb6ef41a6535b6605a6ff80")
    }
}