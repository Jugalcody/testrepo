package com.example.hackerthon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*

class govern_login : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var pass:EditText
    lateinit var code: EditText
    lateinit var btn1:Button
    lateinit var signup:TextView
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_govern_login)

        email=findViewById(R.id.gle1)
        pass=findViewById(R.id.gle2)
        code=findViewById(R.id.gle3)
        btn1=findViewById(R.id.glb1)

        signup=findViewById(R.id.glt1)
btn1.setOnClickListener {

    var email2=email.text.toString()
    var pass2=pass.text.toString()
    var code2=code.text.toString()

    database = FirebaseDatabase.getInstance().getReference("Govt")

database.addValueEventListener(object:ValueEventListener{


        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // Get Post object and use the values to update the UI
            for (s in dataSnapshot.children) {
                println("this is "+s.child("pass").getValue().toString())
                if (email2 == s.key) {

                    if (pass2 == s.child("pass").getValue().toString()) {

                        var i = Intent(this@govern_login, home_gover::class.java)
                        startActivity(i);
                        Toast.makeText(this@govern_login, "welcome", Toast.LENGTH_SHORT).show();
                        break
                    }
                }
            }
        }
        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Post failed, log a message
        }

})


}
        signup.setOnClickListener {

            val i= Intent(this@govern_login,signin_govern::class.java)
            startActivity(i)
        }
    }
}