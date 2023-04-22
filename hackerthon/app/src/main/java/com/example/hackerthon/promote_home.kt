package com.example.hackerthon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
private lateinit var kk2: DatabaseReference
var array= arrayListOf<govt_sign>()
private lateinit var database: DatabaseReference
lateinit var bt14:Button
var i56=""


lateinit var bt15:Button
class promote_home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promote_home)
        sp=getSharedPreferences("email", Context.MODE_PRIVATE)
        val email=sp.getString("email","").toString()
        bt14=findViewById(R.id.psb1)
        bt15=findViewById(R.id.psb2)
        bt14.setOnClickListener {


            val i= Intent(this@promote_home,sell_product::class.java)
            startActivity(i)
        }
        bt15.setOnClickListener {

            kk2 = FirebaseDatabase.getInstance().getReference("itemId")
            database = FirebaseDatabase.getInstance().getReference("sell")


            database.orderByChild("no").addValueEventListener(object: ValueEventListener {


                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    array.clear()

                    for (k in dataSnapshot.children) {
                        for(s in k.children){
                            if(!(govt_sign(s.child("Item").getValue().toString(),s.child("use").getValue().toString(),s.child("price").getValue().toString(),s.child("no").getValue().toString(),s.child("no").getValue().toString()) in array)){

                                array.add( govt_sign(s.child("Item").getValue().toString(),s.child("use").getValue().toString(),s.child("price").getValue().toString(),s.child("no").getValue().toString(),s.child("owner").getValue().toString()))
                            }}}
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }

            })


            val i= Intent(this@promote_home,buy_product::class.java)
            startActivity(i)
        }
    }
}