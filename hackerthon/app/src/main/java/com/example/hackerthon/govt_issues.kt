package com.example.hackerthon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var rec33:RecyclerView
private lateinit var l:LinearLayoutManager
class govt_issues : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_govt_issues)


        sp=getSharedPreferences("email", Context.MODE_PRIVATE)
        val email2=sp.getString("email","")
        rec33=findViewById(R.id.recgovt1)

        l= LinearLayoutManager(this@govt_issues)
        rec33.adapter=adapter2(this@govt_issues,issuearray)
        rec33.layoutManager=l

    }

    override fun onBackPressed() {

        issuearray.clear()
        super.onBackPressed()

    }
    }