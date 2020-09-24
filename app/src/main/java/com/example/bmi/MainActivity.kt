package com.example.bmi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //var bmiArr: ArrayList<User> = ArrayList<User>()
    //var user = user_
    var bmi = 0.0
    var database = FirebaseDatabase.getInstance().getReference("People")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //user = user_.getInstance()!!
        BMI_con.visibility = View.INVISIBLE
        progressBar.visibility = View.INVISIBLE

        calc.setOnClickListener {
            val Name = name.text.toString()
            val Weight = weight.text.toString()
            val Height = hight.text.toString()

            if (Name.isEmpty()) {
                name.error = "Indtast navn"

            } else if (Weight.isEmpty()) {
                weight.error = "Indtast vægt"

            } else if (Height.isEmpty()) {
                hight.error = "Indtast højde"
            } else {

                bmi = Weight.toDouble() / Height.toDouble() / Height.toDouble() * 10000

                BMI.text = bmi.toString().substring(0, 4)
                BMI_con.visibility = View.VISIBLE
            }

            save.setOnClickListener {
                progressBar.visibility = View.VISIBLE
                val peopleId = database.push().key
                val person = Person(Name, bmi.toString().substring(0,4).toDouble())

                if (peopleId != null) {
                    database.child(peopleId).setValue(person)
                        .addOnSuccessListener {
                            progressBar.visibility = View.INVISIBLE
                            BMI_con.visibility = View.INVISIBLE

                            Toast.makeText(applicationContext, "Gemt", Toast.LENGTH_SHORT).show()


                            val intent = Intent(this, page2::class.java)
                            startActivity(intent)

                        }
                        .addOnFailureListener {
                            // Write failed
                            Toast.makeText(applicationContext, "Prøv igen", Toast.LENGTH_SHORT).show()
                        }
                }
            }
        }
    }
}