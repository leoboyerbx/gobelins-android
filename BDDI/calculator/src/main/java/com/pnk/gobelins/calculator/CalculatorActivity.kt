package com.pnk.gobelins.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.pnk.gobelins.calculator.databinding.CalculatorActivityBinding

class CalculatorActivity : AppCompatActivity() {
    lateinit var binding: CalculatorActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.calculator_activity)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        binding.computeButton.setOnClickListener{ this.compute() }
    }

    private fun compute() {
        val operandFirst = binding.number1.text.toString().toIntOrNull() ?: 0
        val operandSecond = binding.number2.text.toString().toIntOrNull() ?: 0

        binding.computeResult.text = "${operandFirst.plus(operandSecond)}"
    }
}
