package com.example.bmi
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_page2.*
import java.util.*
import java.util.jar.Attributes

class page2 : AppCompatActivity() {

    var bmiArr: ArrayList<Person> = ArrayList<Person>()
    val user = user_
    var database = FirebaseDatabase.getInstance().getReference("People")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
        bmiArr.clear()

        var getdata = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                bmiArr.clear()
                for (i in snapshot.children){

                    var name1 : String = i.child("name").getValue() as String
                    var bmi1 : Double

                        if (i.child("bmi").getValue() is Long){
                          var temp  = i.child("bmi").getValue() as Long
                            bmi1 = temp*1.0

                        } else {
                            bmi1 = i.child("bmi").getValue() as Double
                        }

                    bmiArr.add(Person(name1, bmi1.toDouble()))
                    user.setBmiArr(bmiArr, applicationContext)
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        }


        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)

        bmiArr = user.getBmiArr(
            applicationContext
        )!!


        if (bmiArr.size != 0) {
            val adaptor = adapter_list(applicationContext, bmiArr)
            list.adapter = adaptor
        }

        bk.setOnClickListener(){
            val intent = Intent(this, page3 ::class.java)
            startActivity(intent)
        }
    }
}