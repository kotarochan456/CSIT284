package com.example.hirepath
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.util.Log



class ProfileScreenActivity : Activity() {

    // Variable following camelCase
    private lateinit var buttonBack: Button
    private lateinit var textviewUsernameValue: TextView
    private lateinit var textviewPasswordValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        textviewPasswordValue = findViewById(R.id.textviewPasswordValue)

        initializeViews()
        setupClickListeners()
        displayUserData()
        handleIncomingData()
    }

    private fun initializeViews() {
        buttonBack = findViewById<Button>(R.id.buttonBack)
        textviewUsernameValue = findViewById<TextView>(R.id.textviewUsernameValue)

    }

    private fun setupClickListeners() {

        buttonBack.setOnClickListener {
            navigateBackToDashboard()
        }
    }

    private fun displayUserData() {
        intent.getStringExtra("username")?.let { username ->
            Log.d("App", "Profile received username: $username")
            textviewUsernameValue.text = username
        }
    }

    private fun handleIncomingData() {
        intent.getStringExtra("password")?.let { password ->
            // Use .text = password, NOT textviewPasswordValue = password
            textviewPasswordValue.text = password
        }
    }

    private fun navigateBackToDashboard() {
        finish()
    }
}
