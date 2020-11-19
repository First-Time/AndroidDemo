package com.lyf.androiddemo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.lyf.androiddemo.custom.MyTextViewActivity
import com.lyf.androiddemo.edittextstyle.EditTextStyleActivity
import com.lyf.androiddemo.eventdispatch.EventDispatchActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

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
//        val stringArray = resources.getTextArray(R.array.oranges)
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

        textView4.setOnClickListener {
            startActivity(Intent(this@MainActivity, EditTextStyleActivity::class.java))
        }

        textView5.setOnClickListener {
            startActivity(Intent(this@MainActivity, MyTextViewActivity::class.java))
        }

        textView6.setOnClickListener {
            startActivity(Intent(this@MainActivity, EventDispatchActivity::class.java))
        }

        launch {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                asContextElement()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun asContextElement() {
        val myThreadLocal = ThreadLocal<String?>()
        println("1" + myThreadLocal.get()) // Prints "null"
        launch(Dispatchers.Default + myThreadLocal.asContextElement(value = "foo")) {
            println("2" + myThreadLocal.get()) // Prints "foo"
            withContext(Dispatchers.Main) {
                println("3" + myThreadLocal.get()) // Prints "foo", but it's on UI thread
            }
        }
        println("4" + myThreadLocal.get()) // Prints "null"

//        The context element does not track modifications of the thread-local variable, for example:
        myThreadLocal.set("main")
        withContext(Dispatchers.Main) {
            println("5" + myThreadLocal.get()) // Prints "main"
            myThreadLocal.set("UI")
        }
        println("6" + myThreadLocal.get()) // Prints "main", not "UI"。这里输出了 UI，不知道为啥呀

//        Use withContext to update the corresponding thread-local variable to a different value, for example:
        withContext(myThreadLocal.asContextElement("foo")) {
            println("7" + myThreadLocal.get()) // Prints "foo"
        }

//        Accessing the thread-local without corresponding context element leads to undefined value:
        val tl = ThreadLocal.withInitial { "initial" }

        runBlocking {
            println("8" + tl.get()) // Will print "initial"
            // Change context
            withContext(tl.asContextElement("modified")) {
                println("9" + tl.get()) // Will print "modified"
            }
            // Context is changed again
            println("10" + tl.get()) // <- WARN: can print either "modified" or "initial"
        }
    }
}
