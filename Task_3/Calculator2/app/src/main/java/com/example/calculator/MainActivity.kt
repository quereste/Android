package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.add).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("+")
        }

        findViewById<TextView>(R.id.divide).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("/")
        }

        findViewById<TextView>(R.id.multiply).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("*")
        }

        findViewById<TextView>(R.id.subtract).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("-")
        }

        findViewById<TextView>(R.id.power).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("^")
        }

        findViewById<TextView>(R.id.logarithm).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("log")
        }

        findViewById<TextView>(R.id.percent).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("%")
        }

        findViewById<TextView>(R.id.switchSign).setOnClickListener {
           val text: CharSequence = findViewById<TextView>(R.id.outcome).text

            if (text.isNotEmpty()) {
                if (text[0] == '-') {
                    findViewById<TextView>(R.id.outcome).text = text.substring(1)
                } else {
                    findViewById<TextView>(R.id.outcome).text = '-'.toString() + text
                }
            }
        }

        findViewById<TextView>(R.id.clear).setOnClickListener {
            findViewById<TextView>(R.id.outcome).text = ""
        }

        findViewById<TextView>(R.id.equal).setOnClickListener {
            try {
                val whatToCalculate = ExpressionBuilder(findViewById<TextView>(R.id.outcome).text.toString()).build()

                findViewById<TextView>(R.id.outcome).text = String.format("%.3f", whatToCalculate.evaluate())

            } catch (e:Exception){
                findViewById<TextView>(R.id.outcome).text = "ads"
                print("we failed")
            }
        }

        findViewById<TextView>(R.id.keyZero).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("0")
        }

        findViewById<TextView>(R.id.keyOne).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("1")
        }

        findViewById<TextView>(R.id.keyTwo).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("2")
        }

        findViewById<TextView>(R.id.keyThree).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("3")
        }

        findViewById<TextView>(R.id.keyFour).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("4")
        }

        findViewById<TextView>(R.id.keyFive).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("5")
        }

        findViewById<TextView>(R.id.keySix).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("6")
        }

        findViewById<TextView>(R.id.keySeven).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("7")
        }

        findViewById<TextView>(R.id.keyEight).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("8")
        }

        findViewById<TextView>(R.id.keyNine).setOnClickListener {
            findViewById<TextView>(R.id.outcome).append("9")
        }

        findViewById<TextView>(R.id.clear).setOnClickListener {
            findViewById<TextView>(R.id.outcome).text = ""
        }
    }
}