package com.example.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var dbHandler: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.login)
        btnLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

        dbHandler = DatabaseHandler(this)

        val btnRegister = findViewById<Button>(R.id.REG)



        btnRegister.setOnClickListener {

            fun isValidPassword(password: String): Boolean {
                val passwordRegex =
                    Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$")
                return passwordRegex.matches(password)
            }


            val emailEditText = findViewById<EditText>(R.id.REA)
            val firstnameEditText = findViewById<EditText>(R.id.RFN)
            val lastnameEditText = findViewById<EditText>(R.id.RLN)
            val usernameEditText = findViewById<EditText>(R.id.RU)
            val passwordEditText = findViewById<EditText>(R.id.RP)

            val email = emailEditText.text.toString()
            val firstname = firstnameEditText.text.toString()
            val lastname = lastnameEditText.text.toString()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.trim().isNotEmpty() && firstname.trim().isNotEmpty() && lastname.trim()
                    .isNotEmpty() &&
                username.trim().isNotEmpty() && password.trim().isNotEmpty()
            ) {

                if (isValidPassword(password)) {

                    val registrationSuccess =
                        dbHandler.registerUser(email, firstname, lastname, username, password)

                    if (registrationSuccess != -1L) {
                        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show()

                        val intent = Intent(this, Login::class.java)
                        intent.putExtra("USERNAME", username)
                        intent.putExtra("FIRST_NAME", firstname)
                        intent.putExtra("LAST_NAME", lastname)
                        intent.putExtra("EMAIL", email)
                        startActivity(intent)

                        emailEditText.text.clear()
                        firstnameEditText.text.clear()
                        lastnameEditText.text.clear()
                        usernameEditText.text.clear()
                        passwordEditText.text.clear()
                        finish()
                    }

                    else {

                        Toast.makeText(
                            this,
                            "Registration Failed. Please try again.",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                } else {

                    Toast.makeText(
                        this,
                        "Password must contain a small letter, capital letter, number, and special character. Minimum of 8 characters.",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } else {

                Toast.makeText(
                    this,
                    "Email, First Name, Last Name, Username, and Password cannot be blank",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }

    fun onLoginClick(view: View) {}

}
