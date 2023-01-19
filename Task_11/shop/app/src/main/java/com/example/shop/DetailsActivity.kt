package com.example.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            bundle.apply {
                val itemDescription = findViewById<TextView>(R.id.innerDescription)
                itemDescription.text = bundle.getString("description")
            }
        }

        val button: Button = findViewById<Button>(R.id.innerGoBack)

        button.setOnClickListener() {
            val intent: Intent = Intent(this, MainActivity::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT

            startActivityIfNeeded(intent, 0)
        }
    }

}