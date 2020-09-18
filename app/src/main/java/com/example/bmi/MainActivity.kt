package com.example.bmi

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var bmiArr: ArrayList<User> = ArrayList<User>()
    var user = user_



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = user_.getInstance()!!

        BMI_con.visibility = View.INVISIBLE

        calc.setOnClickListener {
            val UserName = name.text.toString()
            val bmiWeight = weight.text.toString().toDouble()
            val bmiHeight = hight.text.toString().toDouble()
            val calcBMI = bmiWeight / bmiHeight / bmiHeight * 10000
            BMI.text = calcBMI.toString().substring(0, 4)
            BMI_con.visibility = View.VISIBLE

            save.setOnClickListener {
                bmiArr.add(User(calcBMI.toString().substring(0, 4).toDouble(), UserName))
                user.setBmiArr(bmiArr, applicationContext)
                BMI_con.visibility = View.INVISIBLE
                val intent = Intent(this, page2::class.java)
                startActivity(intent)
            }
        }


    }
}