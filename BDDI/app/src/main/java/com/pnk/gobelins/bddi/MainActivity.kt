package com.pnk.gobelins.bddi

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity enabling the user to roll a dice and see the result.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        val button: Button = findViewById(R.id.my_button)
        button.setOnClickListener { rollAllDices() }

        rollAllDices()
    }

    /**
     * Roll a 6-faces dice and update the result in the view for the specified imageView
     */
    private fun rollDice(diceImage: ImageView) {
        // Create a dice and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Determine which drawable resource ID to use based on the dice roll
        val diceImageResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceImageResource)
        diceImage.contentDescription = diceRoll.toString()
    }

    private fun rollAllDices() {
        val diceImage1: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        rollDice(diceImage1)
        rollDice(diceImage2)
    }
}

