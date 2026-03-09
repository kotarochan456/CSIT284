package com.example.hirepath

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    // Variables following camelCase
    private lateinit var buttonRegister: Button
    private lateinit var textviewLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initializeViews()
        setupClickListeners()
    }

    private fun initializeViews() {
        buttonRegister = findViewById<Button>(R.id.buttonRegister)
        textviewLogin = findViewById<TextView>(R.id.textviewLogin)

    }

    private fun setupClickListeners() {
        // Requirement: Register to Login (via Submit/Register button)
        buttonRegister.setOnClickListener {
            executeRegistration()
        }

        // Optional but helpful: Navigation back to Login via "Login" text
        textviewLogin.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun executeRegistration() {
        // Logic for "Successful registration"
        val intentLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentLogin)

        // finish() ensures that if the user hits 'back' from the Login screen,
        // they don't end up back in the middle of a registration form.
        finish()
    }

    private fun navigateToLogin() {
        val intentLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentLogin)
        finish()
    }
}