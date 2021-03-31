package com.pnk.gobelins.calculator

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import com.pnk.gobelins.calculator.databinding.CalculatorActivityBinding

class CalculatorActivity : AppCompatActivity() {
    lateinit var binding: CalculatorActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.calculator_activity)
        binding.lifecycleOwner = this
        setContentView(binding.root)
        bind()
    }

    /**
     * Bind all watchers
     */
    private fun bind() {
        binding.computeButton.setOnClickListener { this.sum() }
        binding.number1.doAfterTextChanged {
            sum()
            enableButton()
        }
        binding.number2.doAfterTextChanged {
            sum()
            enableButton()
        }
    }

    private fun sum() {
        with(binding) {
            val operandFirst = number1.toInt()
            val operandSecond = number2.toInt()

            computeResult.text = "${operandFirst.plus(operandSecond)}"
        }
    }

    private fun enableButton() {
        with(binding) {
            binding.computeButton.isEnabled = !number1.text.isNullOrEmpty() && !number2.text.isNullOrEmpty()
        }
    }

    /**
     * Fonction d'extension, va ajouter la méthode toInt aux edittext
     */
    private fun EditText.toInt(): Int = text.toString().toIntOrNull() ?: 0
}
