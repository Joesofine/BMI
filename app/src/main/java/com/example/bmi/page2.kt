package com.example.bmi
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_page2.*
import java.util.*

class page2 : AppCompatActivity() {

    var bmiArr: ArrayList<User> = ArrayList<User>()
    val user = user_


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
        bmiArr = user.getBmiArr(
            applicationContext
        )!!


        if (bmiArr.size != 0) {
            val adaptor = adapter_list(applicationContext, bmiArr)
            list.adapter = adaptor
        }


    }
}