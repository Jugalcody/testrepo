package com.example.hackerthon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

lateinit var but1:Button
lateinit var but2:Button
lateinit var but3:Button
private lateinit var kk2: DatabaseReference
lateinit var but4:Button
lateinit var tt: TextView
lateinit var tool:androidx.appcompat.widget.Toolbar
lateinit var nav: NavigationView
lateinit var draw: DrawerLayout
private lateinit var database: DatabaseReference
private lateinit var kk7: DatabaseReference
var menuItem:MenuItem?=null

class home_citizen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_citizen)

        sp=getSharedPreferences("name", Context.MODE_PRIVATE)
    but1=findViewById(R.id.chb1)
        but2=findViewById(R.id.chb2)
        but3=findViewById(R.id.chb3)
        but4=findViewById(R.id.chb4)




        draw=findViewById(R.id.drawer)
        tool=findViewById(R.id.toolbar)

        nav=findViewById(R.id.nav)

        setSupportActionBar(tool)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val toogle= ActionBarDrawerToggle(
            this@home_citizen, draw,R.string.open,R.string.close)

        draw.addDrawerListener(toogle)
        toogle.syncState()

        nav.setNavigationItemSelectedListener {


            when(it.itemId){

                R.id.profile->{


                    val i= Intent(this@home_citizen,profile::class.java)
                    startActivity(i)
                    draw.close()




                }
R.id.contact->{
    val i= Intent(this@home_citizen,contact::class.java)
    startActivity(i)
    draw.close()
}

                R.id.logout->{

                    val i= Intent(this@home_citizen,MainActivity::class.java)
                    startActivity(i)
                    draw.close()

                    database = FirebaseDatabase.getInstance().getReference("Login2")
                    database.child("Moni").setValue("8963427")

                }

            }

            return@setNavigationItemSelectedListener true

        }




        but1.setOnClickListener {
           kk7= FirebaseDatabase.getInstance().getReference("issueId")
            val i= Intent(this@home_citizen,Problem_S::class.java)
            startActivity(i)

        }

        but2.setOnClickListener {
            val i= Intent(this@home_citizen,Scheme::class.java)
            startActivity(i)
        }


        but3.setOnClickListener {

            val i= Intent(this@home_citizen,promote_home::class.java)
            startActivity(i)
        }


        but4.setOnClickListener {
            val i= Intent(this@home_citizen,abc::class.java)
            startActivity(i)
        }


    }

override fun onOptionsItemSelected(item: MenuItem): Boolean {

    val id=item.itemId
    if(id==android.R.id.home){
        draw.openDrawer(GravityCompat.START)
    }
    return super.onOptionsItemSelected(item)
}

    override fun onBackPressed() {
        val i= Intent(this@home_citizen,MainActivity::class.java)
        startActivity(i)
        super.onBackPressed()
    }
}