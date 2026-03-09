package com.example.hirepath
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.util.Log


class ProfileScreenActivity : AppCompatActivity() {

    // Variable following camelCase
    private lateinit var buttonBack: Button
    private lateinit var textviewUsernameValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        initializeViews()
        setupClickListeners()
        displayUserData()
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

    private fun navigateBackToDashboard() {
        finish()
    }
}