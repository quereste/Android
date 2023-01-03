package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pay_button = findViewById<Button>(R.id.pay_button)
        val buy_button = findViewById<Button>(R.id.buy_button)
        val numberOfProducts = findViewById<TextView>(R.id.number_of_products)

        numberOfProducts.text = "0"

        pay_button.setOnClickListener {
            if (numberOfProducts.text != "0") {
                var i = Intent(this, PayActivity::class.java)
                i.putExtra("message",
                    "Price to pay: " + (numberOfProducts.text.toString()
                        .toDouble() * 7.99).toString()
                )
                startActivity(i)
            } else {
                Toast.makeText(this, "select at least one product", Toast.LENGTH_LONG).show()
            }
        }

        buy_button.setOnClickListener {
            numberOfProducts.text = (Integer.parseInt(numberOfProducts.text.toString()) + 1).toString()
        }
    }
}