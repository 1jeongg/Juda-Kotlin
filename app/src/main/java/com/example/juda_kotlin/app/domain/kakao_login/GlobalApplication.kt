package com.example.juda_kotlin.app.domain.kakao_login

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GlobalApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "b490ad3523748d33cff8c8070f61c958")
    }
}