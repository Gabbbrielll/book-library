package com.example.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class book4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book4)

        val btnBook4start = findViewById<Button>(R.id.btnBook4start)

        val btnbutton = findViewById<Button>(R.id.button)
        btnbutton.setOnClickListener {
            val intent = Intent(this, library::class.java)
            startActivity(intent)
            finish()
        }


        btnBook4start.setOnClickListener{
            val i = Intent(this,book4cont::class.java)
            startActivity(i)
        }
    }
    override fun onBackPressed() {
        val i = Intent(this, library::class.java)
        startActivity(i)
        finish()
        super.onBackPressed()
    }
}