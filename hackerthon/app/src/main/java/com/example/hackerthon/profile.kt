package com.example.hackerthon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.w3c.dom.Text

lateinit var txt1:TextView
lateinit var txt2:TextView
private lateinit var database:DatabaseReference
class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        txt1=findViewById(R.id.p1)
        txt2=findViewById(R.id.p2)
        sp=getSharedPreferences("name", Context.MODE_PRIVATE)

        database = FirebaseDatabase.getInstance().getReference("citizen")
        sp=getSharedPreferences("email", Context.MODE_PRIVATE)
        val email=sp.getString("email","").toString()
        txt2.text="Phone number : $email"
                database.child(email).addValueEventListener(object:
                    ValueEventListener {


                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        txt1.text="Name : ${dataSnapshot.child("name").getValue().toString()}"

                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Getting Post failed, log a message

                    }

                })
    }
}