package com.example.hackerthon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signin_govern : AppCompatActivity() {

    lateinit var edit1: EditText
    lateinit var edit2: EditText
    lateinit var edit3: EditText
    lateinit var edit4: EditText
    lateinit var edit5: EditText
    lateinit var edit6: EditText
    private lateinit var database: DatabaseReference
    lateinit var but9: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_govern)
        edit1=findViewById(R.id.gse1)
        edit2=findViewById(R.id.gse2)
        edit3=findViewById(R.id.gse3)
        edit4=findViewById(R.id.gse4)
        edit5=findViewById(R.id.gse5)
        edit6=findViewById(R.id.gse6)
        but9=findViewById(R.id.gsb1)

        but9.setOnClickListener {

            var name=edit1.text.toString()
            var email=edit2.text.toString()
           var country=edit3.text.toString()
            var pass=edit4.text.toString()
            var pass2=edit5.text.toString()
            var code=edit6.text.toString()
            if(pass==pass2){
                database = FirebaseDatabase.getInstance().getReference("Govt")
                database.child(email).child("name").setValue(name)
                database.child(email).child("country").setValue(country)

                database.child(email).child("pass").setValue(pass)
                database.child(email).child("code").setValue(code)
                val i= Intent(this@signin_govern,govern_login::class.java)
                Toast.makeText(this@signin_govern,"Successfully registered", Toast.LENGTH_SHORT).show()
                startActivity(i)
            }else{
                Toast.makeText(this@signin_govern,"password not matching", Toast.LENGTH_SHORT).show()

            }

        }


    }
}