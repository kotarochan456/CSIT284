package com.example.hirepath

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edittextUsername: EditText
    private lateinit var edittextPassword: EditText
    private lateinit var textviewRegister: TextView
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        edittextUsername = findViewById(R.id.username)
        edittextPassword = findViewById(R.id.password)
        textviewRegister = findViewById(R.id.registerTab)
        buttonLogin = findViewById(R.id.buttonLogin)

        // Navigation to Register
        textviewRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Navigation to Dashboard
        buttonLogin.setOnClickListener {
            val username = edittextUsername.text.toString()
            val password = edittextPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, DashboardScreenActivity::class.java)

                intent.putExtra("username", username)
                intent.putExtra("password", password)

                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid! Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}