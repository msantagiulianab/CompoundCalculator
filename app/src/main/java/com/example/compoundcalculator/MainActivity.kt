package com.example.compoundcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonCalculate: Button = findViewById(R.id.btn_caculate)
        buttonCalculate.setOnClickListener {
            calculateCompoundedSavings()
        }
    }

    private fun calculateCompoundedSavings() {
        val totalCompoundedView: TextView = findViewById(R.id.totalCompounded)
        val interestView: EditText = findViewById(R.id.interest)
        val durationView: EditText = findViewById(R.id.duration)
        val contributionView: EditText = findViewById(R.id.contribution)
        val startingPointView: EditText = findViewById(R.id.startingPoint)

        val startingPoint: Int = startingPointView.text.toString().toInt()
        val interest: Int = interestView.text.toString().toInt()
        val interestNumber: Double = ((100 + interest) / 100.0)
        val duration: Int = durationView.text.toString().toInt()
        val contribution: Double = contributionView.text.toString().toDouble()

        var totalCompounded: Double = startingPoint.toDouble() + contribution

        var count = 1

        if (duration == 1) {
            totalCompoundedView.text = (totalCompounded * interestNumber).toInt().toString()
        } else {
            for (i in 2..duration) {
                totalCompounded = when {
                    count < 6 -> {
                        (totalCompounded * interestNumber) + contribution
                    }
                    count in 6..11 -> {
                        (totalCompounded * interestNumber) + (contribution * 2)
                    }
                    count in 12..23 -> {
                        (totalCompounded * interestNumber) + (contribution * 3)
                    }
                    else -> {
                        (totalCompounded * interestNumber) + (contribution * 4)
                    }
                }
                count++
            }
        }

        totalCompoundedView.text = totalCompounded.toInt().toString()

        return
    }


}