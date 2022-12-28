package com.example.app

import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import org.w3c.dom.Text

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val logout_button = findViewById<Button>(R.id.user_logout)

        val hello_message = findViewById<TextView>(R.id.user_hello_message)

        val user_name = findViewById<TextView>(R.id.user_name)
        val user_surname = findViewById<TextView>(R.id.user_surname)

        val bundle: Bundle? = intent.extras

        hello_message.text = "Hello, " + bundle!!.get("username") + "\nHere are the details of yours"
        user_name.text = "name: " + bundle!!.get("name")
        user_surname.text = "surname: " + bundle!!.get("surname")

        logout_button.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}