package com.example.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {

    private lateinit var dbHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.register)
        btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        dbHandler = DatabaseHandler(this)

        val btnSignIn = findViewById<Button>(R.id.LOGIN)

        btnSignIn.setOnClickListener {
            val usernameEditText = findViewById<EditText>(R.id.LU)
            val passwordEditText = findViewById<EditText>(R.id.LP)

            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.trim().isNotEmpty() && password.trim().isNotEmpty()) {

                val success = dbHandler.loginUser(username, password)

                if (success) {
                    val user = dbHandler.getUserInfo(username)

                    if (user != null) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()

                        val bundle = Bundle()
                        bundle.putString("USERNAME", username)
                        bundle.putString("FIRST_NAME", user.firstName)
                        bundle.putString("LAST_NAME", user.lastName)
                        bundle.putString("EMAIL", user.email)
                        val intent = Intent(this, Profile::class.java)

                        intent.putExtras(bundle)
                        startActivity(intent)

                        usernameEditText.text.clear()
                        passwordEditText.text.clear()

                        finish()
                    }

                    else {
                        Toast.makeText(this, "User information not found", Toast.LENGTH_LONG).show()
                    }
                }

                else {
                    Toast.makeText(this, "Login Unsuccessful. Check your credentials.", Toast.LENGTH_LONG).show()
                }
            }

            else {
                Toast.makeText(this, "Username or Password cannot be blank", Toast.LENGTH_LONG).show()
            }
        }

    }
}

