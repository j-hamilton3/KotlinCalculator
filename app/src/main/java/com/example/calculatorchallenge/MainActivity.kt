/**
 * James Hamilton
 * January 17th, 2024
 * ADEV 3007: Zacharie Montreuil
 */

package com.example.calculatorchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Tracks if an operator was entered. Starts true to prevent user from entering operator first.
    private var operatorEntered: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get all elements by their IDs.
        val calculatorScreen : TextView = findViewById(R.id.calculatorScreen)

        val buttonClear : Button = findViewById(R.id.buttonClear)
        val buttonSeven : Button = findViewById(R.id.buttonSeven)
        val buttonEight : Button = findViewById(R.id.buttonEight)
        val buttonNine : Button = findViewById(R.id.buttonNine)
        val buttonDivide : Button = findViewById(R.id.buttonDivide)
        val buttonFour : Button = findViewById(R.id.buttonFour)
        val buttonFive : Button = findViewById(R.id.buttonFive)
        val buttonSix : Button = findViewById(R.id.buttonSix)
        val buttonMultiply : Button = findViewById(R.id.buttonMultiply)
        val buttonOne : Button = findViewById(R.id.buttonOne)
        val buttonTwo : Button = findViewById(R.id.buttonTwo)
        val buttonThree : Button = findViewById(R.id.buttonThree)
        val buttonMinus : Button = findViewById(R.id.buttonMinus)
        val buttonPlus : Button = findViewById(R.id.buttonPlus)
        val buttonEquals : Button = findViewById(R.id.buttonEquals)

        // Event listeners for the inputs.

        buttonClear.setOnClickListener()
        {
            clearScreen(calculatorScreen)
        }

        // For the number buttons...

        buttonOne.setOnClickListener()
        {
            displayNumber(buttonOne, calculatorScreen)
        }

        buttonTwo.setOnClickListener()
        {
            displayNumber(buttonTwo, calculatorScreen)
        }

        buttonThree.setOnClickListener()
        {
            displayNumber(buttonThree, calculatorScreen)
        }

        buttonFour.setOnClickListener()
        {
            displayNumber(buttonFour, calculatorScreen)
        }

        buttonFive.setOnClickListener()
        {
            displayNumber(buttonFive, calculatorScreen)
        }

        buttonSix.setOnClickListener()
        {
            displayNumber(buttonSix, calculatorScreen)
        }

        buttonSeven.setOnClickListener()
        {
            displayNumber(buttonSeven, calculatorScreen)
        }

        buttonEight.setOnClickListener()
        {
            displayNumber(buttonEight, calculatorScreen)
        }

        buttonNine.setOnClickListener()
        {
            displayNumber(buttonNine, calculatorScreen)
        }

        // For the operator buttons...

        buttonPlus.setOnClickListener()
        {
            displayOperator(buttonPlus, calculatorScreen)
        }

        buttonMinus.setOnClickListener()
        {
            displayOperator(buttonMinus, calculatorScreen)
        }

        buttonMultiply.setOnClickListener()
        {
            displayOperator(buttonMultiply, calculatorScreen)
        }

        buttonDivide.setOnClickListener()
        {
            displayOperator(buttonDivide, calculatorScreen)
        }

        // For the equals functionality...
        buttonEquals.setOnClickListener()
        {
            calculateEquation(calculatorScreen)
        }
    }

    /**
     * Adds a button's operator to the calculator screen.
     *
     * @param button An operator button.
     * @param calculatorScreen The calculator screen TextView.
     */
    fun displayOperator(button: Button, calculatorScreen: TextView)
    {
        if (!operatorEntered)
        {
            calculatorScreen.text = calculatorScreen.text.toString() + " " + button.text.toString() + " "
        }

        operatorEntered = true
    }

    /**
     * Adds a button's number to the calculator screen.
     *
     * @param button A numeric button.
     * @param calculatorScreen The calculator screen TextView.
     */
    fun displayNumber(button: Button, calculatorScreen : TextView)
    {
        operatorEntered = false
        calculatorScreen.text = calculatorScreen.text.toString() + button.text.toString()
    }

    /**
     * Clears the calculator screen.
     *
     * @param calculatorScreen The calculator screen TextView.
     */
    fun clearScreen(calculatorScreen : TextView)
    {
        calculatorScreen.text = ""
        operatorEntered = true
    }

    /**
     * Calculates the equation entered on the calculator screen.
     *
     * @param calculatorScreen The calculator screen TextView.
     */
    fun calculateEquation(calculatorScreen: TextView)
    {
        val equationAsText : String = calculatorScreen.text.toString()

        if (equationAsText.isEmpty())
        {
            println("This should not calculate, the equation is empty.")
        }
        else if (equationAsText.last() == ' ')
        {
            println("This will not calculate, the equation ends with an operator.")
        }
        else
        {
            // Splitting the string into a series of tokens.
            val tokens = equationAsText.split(" ")

            var result = tokens[0].toDouble()

            var i = 1 // To increment through the tokens.

            // Loop through the tokens.
            while (i < tokens.size)
            {
                val operator = tokens[i]
                val nextOperand = tokens[i + 1].toDouble()

                when (operator) {
                    "+" -> result += nextOperand
                    "-" -> result -= nextOperand
                    "*" -> result *= nextOperand
                    "/" -> result /= nextOperand
                }

                i += 2 // Increments by two because operators are every second token.
            }

            // Add the result of the calculation to the calculator screen.
            calculatorScreen.text = result.toString()
        }
    }
}