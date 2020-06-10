package com.lyf.androiddemo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val d = 9.4
        val f = 9.4F
        println(d::class.java)
        println(f::class.java)

        val text1 = resources.getQuantityString(R.plurals.orange, 0, 10)
        textView1.text = text1

        val text2 = resources.getQuantityString(R.plurals.orange, 6, 30)
        textView2.text = text2

        val text3 = resources.getText(0, "我是谁")
        textView3.text = text3

        val stringArray = resources.getStringArray(R.array.oranges)
        for (str in stringArray) {
            println(str)
        }
        println("==================================================")

        val intArray = resources.getIntArray(R.array.number)
        for (num in intArray) {
            println(num)
        }
        println("==================================================")

        val typedArray = resources.obtainTypedArray(R.array.typed_array)
        println("typedArray.length = ${typedArray.length()}")

        for (index in 0 until typedArray.length()) {
            println(
                "index = $index ${typedArray.getIndex(index)} value = ${typedArray.getString(index)}"
            )
            val type = typedArray.getType(index)
            println("type = $type")

            val typedValue = typedArray.peekValue(index)
            println("typedValue.type = ${typedValue.type}")
        }

        println()

        textView0.setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }
    }
}
