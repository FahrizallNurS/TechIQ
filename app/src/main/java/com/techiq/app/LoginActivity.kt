package com.techiq.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextUserName: EditText = findViewById(R.id.username_input)
        val editTextPassword = findViewById<EditText>(R.id.password_input)
        val buttonLogin = findViewById<Button>(R.id.login_btn)

        // lambda function
        buttonLogin.setOnClickListener {
            val username = editTextUserName.text.toString()
            if (username == "Fahrizal" && editTextPassword.text.toString() == "123") {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(KEY_USERNAME, username)
                startActivity(intent)
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
    companion object KEY {
        const val KEY_USERNAME = "USERNAME"
    }
}