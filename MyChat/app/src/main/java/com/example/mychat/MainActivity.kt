    package com.example.mychat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.content.Intent as Intent

    class MainActivity : AppCompatActivity() {


        var name :EditText? = null
        var button : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.nametext)
        button = findViewById(R.id.logbutton)
var _name: String
        var context = this
        button?.setOnClickListener{
     _name = name?.text.toString()
            _name = name?.text.toString()
            var intent = Intent(context, MainActivity2::class.java).apply { }
            intent.putExtra("name1", _name)
            startActivity(intent)


        }



    }
}

