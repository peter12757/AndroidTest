package com.eathemeat.myapplication

import android.app.Application
import com.eathemeat.androidtest.module.AndroidTestModule

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidTestModule.install(this)
    }
}