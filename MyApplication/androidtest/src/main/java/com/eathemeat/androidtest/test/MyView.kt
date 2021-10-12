package com.eathemeat.androidtest.test

import android.content.Context
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.graphics.createBitmap

const val TAG = "MyView"

class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var thread:HandlerThread? = null
    private var handler: MyHandler? = null
    private var buf = createBitmap(300,300)

    init {
//        setBackgroundResource(R.drawable)

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d(TAG, "onDetachedFromWindow: ")
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d(TAG, "onAttachedToWindow: ")
    }

    fun startPost(): Unit {
        if (thread== null) {
            thread = HandlerThread("viewpost")
            thread!!.start()
        }
        if (handler== null)
        handler = MyHandler(this, thread!!.looper)
        handler?.let {
            it.sendEmptyMessageDelayed(0,100)
        }

    }

    fun stopPost(): Unit {
        handler?.let {
            it.sendEmptyMessageDelayed(1,100)
        }
        thread?.quitSafely()
    }



    fun sayHello() {
        Log.d(TAG, "sayHello: ")
    }

    class MyHandler(var view: MyView, looper: Looper): Handler(looper) {

        override fun handleMessage(msg: Message) {
            if (msg.what == 0) {
                view.post(Runnable { view.sayHello() })
                sendEmptyMessageDelayed(0,10)
            }else if (msg.what == 1) {
                removeCallbacksAndMessages(null)
            }
        }

    }


}