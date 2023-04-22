package com.example.hackerthon

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*

lateinit var email: EditText
lateinit var pass: EditText
lateinit var btn3: Button
lateinit var sp:SharedPreferences
private lateinit var database: DatabaseReference
lateinit var signup: TextView
class citizen_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citizen_login)
        email=findViewById(R.id.cle1)
        pass=findViewById(R.id.cle2)
       btn3=findViewById(R.id.clb1)
        signup=findViewById(R.id.clt1)

        btn3.setOnClickListener{

            var email2=email.text.toString()
            var pass2=pass.text.toString()

            database = FirebaseDatabase.getInstance().getReference("citizen")

            database.addValueEventListener(object: ValueEventListener {


                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // Get Post object and use the values to update the UI
                    for (s in dataSnapshot.children) {
                        println("this is "+s.child("pass").getValue().toString())
                        if (email2 == s.key) {

                            if (pass2 == s.child("pass").getValue().toString()) {
                                sp=getSharedPreferences("email", Context.MODE_PRIVATE)
                                sp.edit().apply{putString("email",email2)}.apply()

                                var i = Intent(this@citizen_login, home_citizen::class.java)
                                startActivity(i)

                                Toast.makeText(this@citizen_login, "welcome", Toast.LENGTH_SHORT).show();
                                break
                            }
                        }
                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message
                }

            })
        }

        signup.setOnClickListener {

            val i= Intent(this@citizen_login,signin_citizen::class.java)
            startActivity(i)
        }
    }
}