package com.example.hackerthon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

lateinit var txt:TextView
class header2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_header2)
        txt=findViewById(R.id.user1)
        sp=getSharedPreferences("name", Context.MODE_PRIVATE)
        txt.text=sp.getString("name","")
    }
}