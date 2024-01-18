package com.example.gli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    private lateinit var loginEmail: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        loginEmail = findViewById(R.id.loginEmail)
        loginPassword = findViewById(R.id.loginPassword)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = loginEmail.text.toString().trim()
            val password = loginPassword.text.toString()

            if (email.isEmpty()) {
                loginEmail.error = "Enter Email"
                loginEmail.requestFocus()
            } else if (password.isEmpty()) {
                loginPassword.error = "Enter Password"
                loginPassword.requestFocus()
            } else if (email == "alfagift-admin" && password == "asdf") {
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
            } else {

            }
        }
    }
}
