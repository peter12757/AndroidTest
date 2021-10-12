package com.eathemeat.myapplication

import android.app.Application
import com.eathemeat.androidtest.module.AndroidTestModule
import com.eathemeat.media.MediaModule

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidTestModule.install(this)
        MediaModule.install(this)
    }
}