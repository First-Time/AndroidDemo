package com.lyf.androiddemo.custom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.androiddemo.R
import kotlinx.android.synthetic.main.activity_my_text_view.*

class MyTextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_text_view)

        println(my_text_view)
    }
}
