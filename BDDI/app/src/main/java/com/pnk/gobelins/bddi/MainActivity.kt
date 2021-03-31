package com.pnk.gobelins.bddi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.pnk.gobelins.bddi.databinding.ActivityMainBinding

/**
 * Activity enabling the user to roll a dice and see the result.
 */
class MainActivity : AppCompatActivity() {
    /**
     * lateinit permet de garantir au compilateur qu'on va initialiser la variable dès que possible.
     * Si on oublie de l'initialiser, l'app va planter.
     */
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        val dataChange = DataChange()
        binding.nbClick = dataChange
        binding.myButton.setOnClickListener {
            dataChange.newData()
        }
    }

    /**
     * Roll a 6-faces dice and update the result in the view for the specified imageView
     */
//    private fun rollDice(diceImage: ImageView) {
//        // Create a dice and roll it
//        val dice = Dice(6)
//        val diceRoll = dice.roll()
//
//        // Determine which drawable resource ID to use based on the dice roll
//        val diceImageResource = when (diceRoll) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            else -> R.drawable.dice_6
//        }
//        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.shake)
//        anim.setAnimationListener(object : AnimationListener {
//            override fun onAnimationStart(animation: Animation?) {
//                // nothing to do here
//            }
//
//            override fun onAnimationEnd(animation: Animation?) {
//                diceImage.setImageResource(diceImageResource)
//                diceImage.contentDescription = diceRoll.toString()
//            }
//
//            override fun onAnimationRepeat(animation: Animation?) {
//                // nothing to do here
//            }
//        })
//        diceImage.startAnimation(anim)
//    }
//
//    private fun rollAllDices() {
//        val diceImage1: ImageView = binding.imageView
//        val diceImage2: ImageView = binding.imageView2
//        rollDice(diceImage1)
//        rollDice(diceImage2)
//    }
}
