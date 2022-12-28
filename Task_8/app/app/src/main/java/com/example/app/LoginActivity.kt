package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username_entry = findViewById<EditText>(R.id.login_entry)
        val password_entry = findViewById<EditText>(R.id.password_entry)

        val submit_button = findViewById<Button>(R.id.submit_button)

        val go_back_button = findViewById<Button>(R.id.go_back_login_button)

        submit_button.setOnClickListener {
            val response = ServiceBuilder.buildService(APIService::class.java)

            response.addUser(RequestModel(username_entry.text.toString(), password_entry.text.toString())).enqueue(
                object : Callback<ResponseModel> {
                    override fun onResponse(
                        call: Call<ResponseModel>,
                        response: Response<ResponseModel>
                    ) {

                        if (response.isSuccessful) {
                            var intent = Intent(this@LoginActivity, UserActivity::class.java)
                            intent.putExtra("username", response.body()!!.username)
                            intent.putExtra("password", response.body()!!.password)
                            intent.putExtra("name", response.body()!!.name)
                            intent.putExtra("surname", response.body()!!.surname)

                            startActivity(intent)
                        } else {
                            Toast.makeText(this@LoginActivity, "incorrect data provided", Toast.LENGTH_LONG).show()
                        }

                    }

                    override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "error", Toast.LENGTH_LONG).show()
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
