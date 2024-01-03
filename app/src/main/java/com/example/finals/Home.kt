package com.example.finals


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")

        val tvName = findViewById<TextView>(R.id.fn)
        val btnnext = findViewById<Button>(R.id.next)

        tvName.text = "$firstName $lastName"

        btnnext.setOnClickListener {
            val intent = Intent(this, reading::class.java)
            startActivity(intent)
            finish()
        }


    }
}
