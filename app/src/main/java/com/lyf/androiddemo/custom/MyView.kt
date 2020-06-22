package com.lyf.androiddemo.custom

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.lyf.androiddemo.R

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class MyView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
    View(context, attrs, defStyleAttr, defStyleRes) {

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        R.attr.attr_defStyle
    )

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        R.style.style_defStyleRes
    )

    init {
//        1.优先取在布局中给定的值
//        2.在布局中设置的style中的值
//        3.从defStyleAttr和defStyleRes中取值，注意如果 defStyleAttr有值，则不再去defStyleResult中的值，就算defStyleAttr有的属性没有赋值。（具体看上面的打印结果）
//        4.Theme中设置的属性
//        注意： defStyleAttr的值一定要在Theme中设置才有效果.
//        就拿上面的例子说，如果你没有在Theme中给R.attr.attr_defStyle赋值，而是直接在布局文件中赋值，这样做是没有效果的。

        val typedArray =
            context?.obtainStyledAttributes(attrs, R.styleable.MyView1, defStyleAttr, defStyleRes)
        val text1 = typedArray?.getString(R.styleable.MyView1_text1)
        val text2 = typedArray?.getString(R.styleable.MyView1_text2)
        val text3 = typedArray?.getString(R.styleable.MyView1_text3)
        val text4 = typedArray?.getString(R.styleable.MyView1_text4)
        val text5 = typedArray?.getString(R.styleable.MyView1_text5)
        println("text1 == $text1")
        println("text2 == $text2")
        println("text3 == $text3")
        println("text4 == $text4")
        println("text5 == $text5")
//        text1 == Direct declare in xml
//        text2 == text2-declare in style_MyViewStyle
//        text3 == text3-declare in style_attr_defStyleAttr
//        text4 == text4-declare in Theme
//        text5 == text5-declare in Theme
        typedArray?.recycle()
    }
}