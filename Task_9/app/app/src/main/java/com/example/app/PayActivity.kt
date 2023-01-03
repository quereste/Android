package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PayActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        val bundle: Bundle? = intent.extras

        val card_entry = findViewById<EditText>(R.id.card_number)
        val cvc_entry = findViewById<EditText>(R.id.cvc_entry)
        val date_entry = findViewById<EditText>(R.id.date_entry)

        val total_price_text = findViewById<TextView>(R.id.total_price)

        total_price_text.text = bundle!!.get("message").toString()

        val submit_button = findViewById<Button>(R.id.submit_button)

        val go_back_button = findViewById<Button>(R.id.go_back_login_button)

        submit_button.setOnClickListener {
            val response = ServiceBuilder.buildService(APIService::class.java)

            response.pay(RequestModel(card_entry.text.toString(), cvc_entry.text.toString(), date_entry.text.toString())).enqueue(
                object : Callback<ResponseModel> {
                    override fun onResponse(
                        call: Call<ResponseModel>,
                        response: Response<ResponseModel>
                    ) {

                        if (response.isSuccessful) {
                            var intent = Intent(this@PayActivity, PaymentSuccessfulActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@PayActivity, "incorrect data provided", Toast.LENGTH_LONG).show()
                        }

                    }

                    override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                        Toast.makeText(this@PayActivity, "error", Toast.LENGTH_LONG).show()
                    }

                }
            )


        }

        go_back_button.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            i.putExtra("asd", "asd")
            startActivity(i)
        }
    }
}
