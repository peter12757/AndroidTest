package com.eathemeat.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.eathemeat.androidtest.test.MyView

class AndroidTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_test)
        findViewById<Button>(R.id.btn_startpost).setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                findViewById<MyView>(R.id.mv_test1).startPost()
            }
        })
        findViewById<Button>(R.id.btn_removeview).setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                findViewById<ConstraintLayout>(R.id.cl_all).removeView(findViewById<Button>(R.id.ll_content))
            }
        })
    }


}