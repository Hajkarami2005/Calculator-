package com.example.anil_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var selectedOperator = ""
    var oldNumber = ""
    var answerHistory = ""
    var isNewOperation = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickButtonEvent(view: View) {
        if (isNewOperation) {
            clear()
        }
        isNewOperation = false
        val selelctedButton = view as Button
        val currentNumber: String = showNumber.text.toString()
        val newNumber = setNextCharacter(currentNumber, selelctedButton)
        showNumber.text = newNumber
    }

    fun setNextCharacter(oldNumber: String, selectedButton: Button): String {
        var number = oldNumber
        when (selectedButton.id) {
            btn_0.id -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    number += "0"
                }
            }
            btn_1.id -> {
                if (number == "0" || number == "") {
                    number = "1"
                } else {
                    number += "1"
                }
            }
            btn_2.id -> {
                if (number == "0" || number == "") {
                    number = "2"
                } else {
                    number += "2"
                }
            }
            btn_3.id -> {
                if (number == "0" || number == "") {
                    number = "3"
                } else {
                    number += "3"
                }
            }
            btn_4.id -> {
                if (number == "0" || number == "") {
                    number = "4"
                } else {
                    number += "4"
                }
            }
            btn_5.id -> {
                if (number == "0" || number == "") {
                    number = "5"
                } else {
                    number += "5"
                }
            }
            btn_6.id -> {
                if (number == "0" || number == "") {
                    number = "6"
                } else {
                    number += "6"
                }
            }
            btn_7.id -> {
                if (number == "0" || number == "") {
                    number = "7"
                } else {
                    number += "7"
                }
            }
            btn_8.id -> {
                if (number == "0" || number == "") {
                    number = "8"
                } else {
                    number += "8"
                }
            }
            btn_9.id -> {
                if (number == "0" || number == "") {
                    number = "9"
                } else {
                    number += "9"
                }
            }
            btn_doot.id -> {
                if (number == "") {
                    number = "0."
                } else {
                    if (number.indexOf('.') == -1){
                        number += "."
                    }
                }
            }
            btn_sign.id -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    if (number.first() == '-') {
                        number = number.substring(1, number.lastIndex + 1)
                    } else {
                        number = "-$number"
                    }
                }
            }
        }

        return number

    }

    fun selectedOperatorEvent(view: View) {
        val selectedButton = view as Button
        when (selectedButton.id) {
            btn_division.id -> {
                selectedOperator = "/"
            }
            btn_molti.id -> {
                selectedOperator = "*"
            }
            btn_sub.id -> {
                selectedOperator = "+"
            }
            btn_subtraction.id -> {
                selectedOperator = "-"
            }
        }
        oldNumber = showNumber.text.toString()
        val curentOprator = selectedOperator
        showNumber.text = oldNumber + curentOprator
        showNumber.text = "0"
        isNewOperation = true
    }
    fun equalEvent(view: View) {
        view as Button
        val newNumber = showNumber.text.toString().toDouble()
        var answer: Double? = null
        if(selectedOperator != "" && oldNumber != ""){
            when (selectedOperator) {
                "/" -> {
                    answer = oldNumber.toDouble() / newNumber
                }
                "*" -> {
                    answer = oldNumber.toDouble() * newNumber
                }
                "+" -> {
                    answer = oldNumber.toDouble() + newNumber
                }
                "-" -> {
                    answer = oldNumber.toDouble() - newNumber
                }
            }
            showNumber.text = answer.toString()
            answerHistory = answer.toString()
            isNewOperation = true
            oldNumber = answerHistory
            selectedOperator = ""
        }
    }
    fun clear() {
        showNumber.text = "0"
    }

    fun peresentageEvent(view: View) {
        view as Button
        val number = showNumber.text.toString().toDouble()
        val peresantage = number / 100
        showNumber.text = peresantage.toString()
        isNewOperation = true
    }

    fun clearInput(view: View) {
        clear()
        selectedOperator = ""
        isNewOperation = true
    }
}
