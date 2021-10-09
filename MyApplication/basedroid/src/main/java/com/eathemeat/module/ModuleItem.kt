package com.eathemeat.module

import android.content.Context

interface ModuleItem {
    /**
     *
     */
    fun getTitle(): String

    fun install(ctx: Context)

    fun startUp(ctx: Context)



}