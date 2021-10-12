package com.eathemeat.media

import android.content.Context
import android.content.Intent
import com.eathemeat.module.ModuleItem
import com.eathemeat.module.ModuleManager

object MediaModule :ModuleItem {
    override fun getTitle(): String {
        return "FFmpegDemo"
    }

    override fun install(ctx: Context) {
        ModuleManager.register(this)
    }

    override fun startUp(ctx: Context) {
        var intent = Intent(ctx,MediaPlayerActivity::class.java)
        ctx.startActivity(intent)
    }
}