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
        KakaoSdk.init(this, "b490ad3523748d33cff8c8070f61c958")
    }
}