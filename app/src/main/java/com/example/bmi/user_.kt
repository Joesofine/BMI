package com.example.bmi

import android.content.Context
import com.example.bmi.user_.ourInstance
import com.example.bmi.user_.user_
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

public object user_ {

    private val ourInstance: user_ = user_
    var bmiArr: ArrayList<Person> = ArrayList<Person>()
    public fun getInstance(): com.example.bmi.user_? {
        return ourInstance
    }

    private fun user_() {}

    fun setBmiArr(arr: ArrayList<Person>?, context: Context?) {
        saveUser(context!!, arr!!)
    }


    fun getBmiArr(context: Context?): ArrayList<Person>? {
        bmiArr.clear()
        loadUser(context!!)
        return bmiArr
    }



    private fun saveUser(context: Context, arr: ArrayList<Person>) {
        val sharedPreferences = context.getSharedPreferences("Users", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(arr)
        editor.putString("bmiArr", json)
        editor.apply()
    }

    private fun loadUser(context: Context) {
        val sharedPreferences = context.getSharedPreferences("Users", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("bmiArr", null)
        val type = object : TypeToken<ArrayList<Person?>?>() {}.type
        bmiArr = gson.fromJson(json, type)
        if (bmiArr == null) {
            bmiArr = ArrayList()
        }
    }







}