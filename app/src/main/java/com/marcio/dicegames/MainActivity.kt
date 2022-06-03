package com.marcio.dicegames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {

    data class Input(val number1: Int, val number2: Int)


    fun getInput(): Input {
        println("First enter the first Number then Enter and the Second Number please: ")

        val user1 = readLine() ?: "0"
        val parsedNumber1 = try {
            user1.toInt()
        } catch (e: Exception) {
            println("That's not a valid number")
            0
        }

        val input1 = if (parsedNumber1 == 0) {
            getInput()
        } else {
            parsedNumber1
        }

        val user2 = readLine() ?: "0"
        val parsedNumber2 = try {
            user2.toInt()
        } catch (e: Exception) {
            println("That's not a valid number")
            0
        }


        val input: Input = if (parsedNumber1 == 0 || parsedNumber2 == 0) {
            getInput()
        } else {
            Input(parsedNumber1, parsedNumber2)
        }

        return input
    }

    val values = getInput()

    val firstDice = Dice(6)
    val secondDice = Dice(6)

    val answer1 = firstDice.roll()
    val answer2 = secondDice.roll()

    if (values.number1 == answer1) {
        println("Marcio you got it!")
    } else {
        println("Marcio you failed!")
    }
    if (values.number2 == answer2) {
        println("Wendy you got it!")
    } else {
        println("Wendy you failed!")
    }
}

open class Dice(var sides: Int) {
    fun roll(): Int {
        val result = (1..sides).random()
        println("$result")
        return result
    }
}