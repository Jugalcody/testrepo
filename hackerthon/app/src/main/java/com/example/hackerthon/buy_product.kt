package com.example.hackerthon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

private lateinit var l:RecyclerView.LayoutManager
lateinit var rec:RecyclerView

class buy_product : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_product)
        sp=getSharedPreferences("email", Context.MODE_PRIVATE)
  val email2=sp.getString("email","")
        rec=findViewById(R.id.rec)
            l=LinearLayoutManager(this@buy_product)
            rec.adapter=adapter(this@buy_product,array)
            rec.layoutManager=l

    }

    override fun onBackPressed() {

        array.clear()
        super.onBackPressed()

    }


}