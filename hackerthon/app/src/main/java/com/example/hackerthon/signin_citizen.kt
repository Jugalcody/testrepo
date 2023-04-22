package com.example.hackerthon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var edit1:EditText
lateinit var edit2:EditText
lateinit var edit3:EditText
lateinit var edit4:EditText
lateinit var edit5:EditText
private lateinit var database: DatabaseReference
lateinit var but9:Button
class signin_citizen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_citizen)

        edit1=findViewById(R.id.cse1)
        edit2=findViewById(R.id.cse2)
        edit3=findViewById(R.id.cse3)
        edit4=findViewById(R.id.cse4)
        edit5=findViewById(R.id.cse5)
        but9=findViewById(R.id.csb1)

        but9.setOnClickListener {

            var name=edit1.text.toString()
            var email=edit2.text.toString()
            var country=edit3.text.toString()
            var pass=edit4.text.toString()
            var pass2=edit5.text.toString()

if(pass==pass2){
    sp=getSharedPreferences("name", Context.MODE_PRIVATE)
    sp.edit().apply{putString("name",name)}.apply()

    database = FirebaseDatabase.getInstance().getReference("citizen")
    database.child(email).child("name").setValue(name)
    database.child(email).child("country").setValue(country)
    database.child(email).child("pass").setValue(pass)
    val i= Intent(this@signin_citizen,citizen_login::class.java)
    Toast.makeText(this@signin_citizen,"Successfully registered", Toast.LENGTH_SHORT).show()
    startActivity(i)
        }else{
            Toast.makeText(this@signin_citizen,"password not matching",Toast.LENGTH_SHORT).show()

        }

    }
}}