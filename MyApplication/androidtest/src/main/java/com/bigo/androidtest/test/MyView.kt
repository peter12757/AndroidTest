package com.bigo.androidtest.test

import android.content.Context
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View

const val TAG = "MyView"

class MyView(context: Context?) : View(context) {

    private var thread:HandlerThread? = null
    private var handler:MyHandler? = null

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d(TAG, "onDetachedFromWindow: ")
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d(TAG, "onAttachedToWindow: ")
    }

    fun startPost(): Unit {
        thread = HandlerThread("viewpost")
        handler = MyHandler(this,thread!!.looper)
        handler?.let {
            it.sendEmptyMessageDelayed(0,100)
        }

    }

    fun stopPost(): Unit {
        handler?.let {
            it.sendEmptyMessageDelayed(1,100)
        }
    }

    fun sayHello() {
        Log.d(TAG, "sayHello: ")
    }

    class MyHandler(var view: MyView,looper: Looper): Handler(looper) {

        override fun handleMessage(msg: Message) {
            if (msg.what == 0) {
                view.post(Runnable { run { view.sayHello() } })
                sendEmptyMessageDelayed(0,10)
            }else if (msg.what == 1) {
                removeCallbacksAndMessages(null)
            }
        }

    }


}