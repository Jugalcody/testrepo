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

lateinit var prm:Button
private lateinit var kk2: DatabaseReference
var issuearray= arrayListOf<issueClass>()
private lateinit var database: DatabaseReference
class home_gover : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_gover)
        prm=findViewById(R.id.gmh3)
        prm.setOnClickListener{
//}
            sp2=getSharedPreferences("email", Context.MODE_PRIVATE)
            var email4=sp2.getString("email","").toString()
            kk2 = FirebaseDatabase.getInstance().getReference("issueId")
            database = FirebaseDatabase.getInstance().getReference("issue")


            database.addValueEventListener(object: ValueEventListener {


                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    issuearray.clear()

                    for (k in dataSnapshot.children) {
                        for(s in k.children){
                           if(!(issueClass(s.child("issueId").getValue().toString(),s.child("issue").getValue().toString(),s.child("owner").getValue().toString()) in issuearray)){
                            issuearray.add(issueClass(s.child("issueId").getValue().toString(),s.child("issue").getValue().toString(),s.child("owner").getValue().toString()))

                            }}}}

                override fun onCancelled(databaseError: DatabaseError) {

                }

            })
            val i= Intent(this@home_gover,govt_issues::class.java)
            startActivity(i)
        }
    }
}