package com.example.mychat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class MainActivity2 : AppCompatActivity() {
    var textmes : EditText? = null
    var button : Button? = null
    var text : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
text = findViewById(R.id.textView)

        var sname :String = intent.getStringExtra("name1").toString()
 textmes = findViewById(R.id.edMes)

 button = findViewById(R.id.button2)

        button?.setOnClickListener{
            var tmessage3 = textmes?.text.toString()
            val database = Firebase.database("https://mychat-8d023-default-rtdb.europe-west1.firebasedatabase.app/")
            val myRef = database.getReference("message")
            myRef.setValue(sname+": "+tmessage3)
        }
val db = Firebase.database("https://mychat-8d023-default-rtdb.europe-west1.firebasedatabase.app/")
        val ref = db.getReference("message")
       onChangeListener(ref)

    }
    private fun onChangeListener(dRef: DatabaseReference){
        dRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                text?.append("\n")
                text?.append(snapshot.value.toString())

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }
}