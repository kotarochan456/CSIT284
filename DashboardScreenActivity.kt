package com.example.hirepath

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class DashboardScreenActivity : Activity() {

    // Declaring variables using camelCase
    private lateinit var imageviewProfilePicture: ImageView
    private lateinit var buttonLogout: Button
    private lateinit var textviewUser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_screen)

        initializeViews()
        setupClickListeners()
        handleIncomingData()
    }

    private fun initializeViews() {
        imageviewProfilePicture = findViewById<ImageView>(R.id.imageviewProfilePicture)
        buttonLogout = findViewById<Button>(R.id.buttonLogout)
        textviewUser = findViewById<TextView>(R.id.textviewUser)
    }

    private fun setupClickListeners() {
        // Requirement: Dashboard to Profile
        imageviewProfilePicture.setOnClickListener {
            navigateToProfile()
        }

        // Requirement: Dashboard to Login (Logout)
        buttonLogout.setOnClickListener {
            executeLogout()
        }
    }

    private fun navigateToProfile() {
        val intentProfile = Intent(this, ProfileScreenActivity::class.java)

        // Pass the username currently displayed on the Dashboard
        val currentUsername = textviewUser.text.toString().replace("Welcome ", "")
        intentProfile.putExtra("username", currentUsername)

        // ADD THIS: Get the password that was sent to the Dashboard and pass it to Profile
        val receivedPassword = intent.getStringExtra("password")
        intentProfile.putExtra("password", receivedPassword)

        startActivity(intentProfile)
    }

    private fun handleIncomingData() {
        intent.getStringExtra("username")?.let { username ->
            Log.d("App", "Received username: $username")
            textviewUser.text = "Welcome $username"
        }
    }

    private fun executeLogout() {
        val intentLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentLogin)
        finish()
    }
}
