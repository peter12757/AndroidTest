package com.bigo.androidtest.module

import android.content.Context
import android.content.Intent
import com.bigo.androidtest.AndroidTestActivity
import com.eathemeat.module.ModuleItem
import com.eathemeat.module.ModuleManager

object AndroidTestModule : ModuleItem {
    override fun getTitle(): String {
        return AndroidTestModule::class.toString()
    }

    override fun install(ctx: Context) {
        ModuleManager.register(this)
    }

    override fun startUp(ctx: Context) {
        var intent = Intent(ctx,AndroidTestActivity::class.java)
        ctx.startActivity(intent)
    }


}