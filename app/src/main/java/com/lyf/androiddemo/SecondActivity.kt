package com.lyf.androiddemo

import android.os.Bundle
import android.util.SparseArray
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
//    lateinit var sparseArray: SparseArray<String>
    lateinit var hashMap: HashMap<Int, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /*sparseArray = SparseArray<String>()
        for (i in 1..100000) {
            sparseArray.put(i, i.toString())
        }*/

        hashMap = hashMapOf()
        for (i in 1..100000) {
            hashMap[i] = i.toString()
        }
    }
}
