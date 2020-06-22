package com.lyf.androiddemo.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.lyf.androiddemo.R

class MyTextView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null, 0)

    init {
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.MyTextView)

        val text = typedArray?.getString(R.styleable.MyTextView_text)

        val testAttr = typedArray?.getInteger(R.styleable.MyTextView_testAttr, -1)

        println("test = $text")
        println("testAttr = $testAttr")

        typedArray?.recycle()
    }
}