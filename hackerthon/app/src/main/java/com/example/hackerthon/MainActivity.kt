package com.example.hackerthon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var btn1:Button
lateinit var btn2:Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1=findViewById(R.id.govern)
        btn2=findViewById(R.id.citizen)
        btn2.setOnClickListener {
            var i=Intent(this@MainActivity,citizen_login::class.java)
                    startActivity(i)
        }

        btn1.setOnClickListener{
            var i=Intent(this@MainActivity,govern_login::class.java)
            startActivity(i)
        }
    }
}