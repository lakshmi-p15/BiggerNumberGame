package com.example.biggernumbergame

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.biggernumbergame.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        assignNumbersToButtons()
        binding.btnLeft.setOnClickListener {
            Toast.makeText(this, "left button clicked", Toast.LENGTH_SHORT).show()
            compareNumbers(true)
            assignNumbersToButtons()
        }

        binding.btnRight.setOnClickListener {
            Toast.makeText(this, "Right button clicked", Toast.LENGTH_SHORT).show()
            compareNumbers(false)
            assignNumbersToButtons()
        }

    }

    private fun assignNumbersToButtons() {
        val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while (rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }
        binding.btnLeft.text = leftNum.toString()
        binding.btnRight.text = rightNum.toString()
    }

    private fun compareNumbers(isLeftButtonClicked: Boolean) {
        val leftNum = binding.btnLeft.text.toString().toInt()
        val rightNum = binding.btnRight.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonClicked) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            binding.backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show()
        } else {
            binding.backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
        }

    }
}