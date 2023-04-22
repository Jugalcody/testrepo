package com.example.hackerthon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.NullPointerException
import java.math.BigInteger

lateinit var edit12:EditText
lateinit var edit22:EditText
lateinit var edit32:EditText
var owner=""
var id=""
lateinit var but27:Button
private lateinit var database: DatabaseReference
private lateinit var owner2: DatabaseReference
private lateinit var kk2: DatabaseReference
class sell_product : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_product)
        edit12=findViewById(R.id.pselle1)
        edit22=findViewById(R.id.pselle2)
        edit32=findViewById(R.id.pselle3)

        but27=findViewById(R.id.pselle4)

        sp=getSharedPreferences("email", Context.MODE_PRIVATE)
        val email=sp.getString("email","").toString()
var i2="0"
        but27.setOnClickListener {

            val item=edit12.text.toString()
            val use=edit22.text.toString()
            val price=edit32.text.toString()


          database = FirebaseDatabase.getInstance().getReference("sell")
           owner2 = FirebaseDatabase.getInstance().getReference("citizen")
            kk2 = FirebaseDatabase.getInstance().getReference("itemId")
            kk2.addValueEventListener(object: ValueEventListener {


                override fun onDataChange(dataSnapshot: DataSnapshot) {
               id= (dataSnapshot.getValue()?:"0").toString()

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message

                }

            })


            owner2.child(email).addValueEventListener(object: ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {



                    owner = dataSnapshot.child("name").getValue().toString()
                    database = FirebaseDatabase.getInstance().getReference("sell")

    database.child(email).child((id.toInt()+1).toString()).child("Item").setValue(item)
    database.child(email).child((id.toInt()+1).toString()).child("use").setValue(use)
    database.child(email).child((id.toInt()+1).toString()).child("owner").setValue(owner)
    database.child(email).child((id.toInt()+1).toString()).child("no").setValue((id.toInt()+1).toString())
    database.child(email).child((id.toInt()+1).toString()).child("price").setValue(price)
    edit12.setText("")
    edit22.setText("")
    edit32.setText("")
    Toast.makeText(this@sell_product, "shared", Toast.LENGTH_SHORT).show();
                    println("pp -- $id")
                    kk2 = FirebaseDatabase.getInstance().getReference("itemId")
                    kk2.setValue((id.toInt()+1).toString())



}

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message

                }

            })


        }


    }

}

