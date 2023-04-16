package com.tresdos.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var operationText: String = ""
    private var firstNumber: String = ""
    private var secondNumber: String = ""
    private var waitingResult: Boolean = false
    private  var currentSymbol: String = ""

    private lateinit var btnNum1: Button
    private lateinit var btnNum2: Button
    private lateinit var btnNum3: Button
    private lateinit var btnNum4: Button
    private lateinit var btnNum5: Button
    private lateinit var btnNum6: Button
    private lateinit var btnNum7: Button
    private lateinit var btnNum8: Button
    private lateinit var btnNum9: Button
    private lateinit var btnPercent: Button
    private lateinit var btnPlus: Button
    private lateinit var btnSus: Button
    private lateinit var btnMul: Button
    private lateinit var btnDiv: Button
    private lateinit var btnResult: Button
    private lateinit var btnClear: Button

    private lateinit var tvOperation: TextView
    private lateinit var tvShowRes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        initListeners()
    }

    private fun initComponent() {
        btnNum1 = findViewById(R.id.btnNum1)
        btnNum2 = findViewById(R.id.btnNum2)
        btnNum3 = findViewById(R.id.btnNum3)
        btnNum4 = findViewById(R.id.btnNum4)
        btnNum5 = findViewById(R.id.btnNum5)
        btnNum6 = findViewById(R.id.btnNum6)
        btnNum7 = findViewById(R.id.btnNum7)
        btnNum8 = findViewById(R.id.btnNum8)
        btnNum9 = findViewById(R.id.btnNum9)
        btnPercent = findViewById(R.id.btnPercent)
        btnPlus = findViewById(R.id.btnPlus)
        btnSus = findViewById(R.id.btnSus)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)
        btnResult = findViewById(R.id.btnResult)
        btnClear = findViewById(R.id.btnClear)

        tvOperation = findViewById(R.id.tvOperation)
        tvShowRes = findViewById(R.id.tvShowRes)

    }

    private fun initListeners() {
        btnNum1.setOnClickListener { appendTextToOperation("1") }
        btnNum2.setOnClickListener { appendTextToOperation("2") }
        btnNum3.setOnClickListener { appendTextToOperation("3") }
        btnNum4.setOnClickListener { appendTextToOperation("4") }
        btnNum5.setOnClickListener { appendTextToOperation("5") }
        btnNum6.setOnClickListener { appendTextToOperation("6") }
        btnNum7.setOnClickListener { appendTextToOperation("7") }
        btnNum8.setOnClickListener { appendTextToOperation("8") }
        btnNum9.setOnClickListener { appendTextToOperation("9") }

        btnPercent.setOnClickListener { appendTextToOperation("%") }
        btnPlus.setOnClickListener { appendTextToOperation("+") }
        btnSus.setOnClickListener { appendTextToOperation("-") }
        btnMul.setOnClickListener { appendTextToOperation("x") }
        btnDiv.setOnClickListener { appendTextToOperation("/") }

        btnClear.setOnClickListener {
            tvOperation.text = ""
            tvShowRes.text = ""
        }
    }

    private fun appendTextToOperation(numOrSymbol: String) {
        println(numOrSymbol)
        operationText = operationText.plus(numOrSymbol)
        tvOperation.text = operationText

        if(!waitingResult) {
            firstNumber = operationText
        } else {
            secondNumber = operationText.substring(firstNumber.length)
        }

      /*  when(numOrSymbol) {
            "+" -> {
                waitingResult = true
                tvShowRes.text = sumOperation().toString()
            }
        }*/

    }

    private fun sumOperation(): Int {
        return firstNumber.toInt() + secondNumber.toInt()
    }
}