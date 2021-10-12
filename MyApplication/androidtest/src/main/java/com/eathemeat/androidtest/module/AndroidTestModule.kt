package com.eathemeat.androidtest.module

import android.content.Context
import android.content.Intent
import com.eathemeat.androidtest.AndroidTestActivity
import com.eathemeat.module.ModuleItem
import com.eathemeat.module.ModuleManager

object AndroidTestModule : ModuleItem {

    override fun getTitle(): String {
        return "Android测试"
    }

    override fun install(ctx: Context) {
        ModuleManager.register(this)
    }

    override fun startUp(ctx: Context) {
        var intent = Intent(ctx, AndroidTestActivity::class.java)
        ctx.startActivity(intent)
    }


}