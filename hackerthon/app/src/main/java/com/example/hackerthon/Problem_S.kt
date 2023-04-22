package com.example.hackerthon

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
private lateinit var kk2: DatabaseReference
lateinit var e1:EditText
lateinit var sp2:SharedPreferences
lateinit var b1:Button
private var id2="0"
private lateinit var database: DatabaseReference
private lateinit var owner2: DatabaseReference
class Problem_S : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sp=getSharedPreferences("email", Context.MODE_PRIVATE)
        val email=sp.getString("email","").toString()
        setContentView(R.layout.activity_problem_s)
        sp2=getSharedPreferences("email", Context.MODE_PRIVATE)
        var email4=sp2.getString("email","").toString()
        e1=findViewById(R.id.chpe1)
        b1=findViewById(R.id.chpb1)
        sp=getSharedPreferences("owner",Context.MODE_PRIVATE)
        b1.setOnClickListener {
            database = FirebaseDatabase.getInstance().getReference("issue")
            owner2 = FirebaseDatabase.getInstance().getReference("citizen")
            kk2 = FirebaseDatabase.getInstance().getReference("issueId")

            kk2.addValueEventListener(object: ValueEventListener {


                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    id2= (dataSnapshot.getValue()?:"0").toString()



                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message

                }

            })

            owner2.child(email4).addValueEventListener(object: ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    owner = dataSnapshot.child("name").getValue().toString()

                    sp.edit().apply{putString("owner",owner)}.apply()

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message

                }

            })




            if (e1.text.toString() != "") {
owner= sp.getString("owner","").toString()
                val e2 = e1.text.toString()
                database.child(email4).child(id2).child("issueId").setValue(id2)
                database.child(email4).child(id2).child("issue").setValue(e2)
                database.child(email4).child(id2).child("owner").setValue(owner)
                e1.setText("")

                Toast.makeText(this@Problem_S, "sent issue with id $id2", Toast.LENGTH_SHORT).show()




            }
            else{
                Toast.makeText(this@Problem_S, "empty issue", Toast.LENGTH_SHORT).show()
            }

            FirebaseDatabase.getInstance().getReference("issueId").setValue((id2.toInt()+1)).toString()


                    }




        }
    }