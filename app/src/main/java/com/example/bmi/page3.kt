package com.example.bmi

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_page3.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class page3 : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)

        GlobalScope.launch(Dispatchers.IO) {
            val id = "1TM-GdlklF1xUKt0mgrkuQ47eCrFGgQSGkpM2q2u-ZCg"
            val url = "https://docs.google.com/spreadsheets/d/$id/export?format=csv&id=$id"

            val csv = URL(url).readText().split("\n")
            val kode = csv[1].split(",")[1]

            this@page3.runOnUiThread {
                textView.text = "$kode er sej"
            }
        }


    }
    private fun readText(){

    }
}