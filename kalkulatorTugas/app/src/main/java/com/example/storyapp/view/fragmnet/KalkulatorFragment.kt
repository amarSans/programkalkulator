package com.example.storyapp.view.fragmnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.storyapp.R


class KalkulatorFragment : Fragment() {

    private lateinit var angka1: EditText
    private lateinit var hasil: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button0: Button
    private lateinit var button00: Button
    private lateinit var buttontitik: Button
    private lateinit var buttonTambah: Button
    private lateinit var buttonKurang: Button
    private lateinit var buttonKali: Button
    private lateinit var buttonBagi: Button
    private lateinit var buttonBackspace: Button
    private lateinit var buttonEquals: Button
    // TODO: Rename and change types of parameters




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_kalkulator, container, false)

        // Inisialisasi elemen UI di sini
        angka1 = view.findViewById(R.id.angka1)
        hasil = view.findViewById(R.id.tv_hasil)
        button1 = view.findViewById(R.id.button1)
        button2 = view.findViewById(R.id.button2)
        button3 = view.findViewById(R.id.button3)
        button4 = view.findViewById(R.id.button4)
        button5 = view.findViewById(R.id.button5)
        button6 = view.findViewById(R.id.button6)
        button7 = view.findViewById(R.id.button7)
        button8 = view.findViewById(R.id.button8)
        button9 = view.findViewById(R.id.button9)
        button0 = view.findViewById(R.id.button0)
        button00 = view.findViewById(R.id.button00)
        buttontitik = view.findViewById(R.id.buttonTitik)
        buttonTambah = view.findViewById(R.id.buttonTambah)
        buttonKurang = view.findViewById(R.id.buttonkurang)
        buttonKali = view.findViewById(R.id.buttonKali)
        buttonBagi = view.findViewById(R.id.buttonBagi)
        buttonBackspace = view.findViewById(R.id.backspace)
        buttonEquals = view.findViewById(R.id.btn_samadengan)

        button1.setOnClickListener { appendToInput("1") }
        button2.setOnClickListener { appendToInput("2") }
        button3.setOnClickListener { appendToInput("3") }
        button4.setOnClickListener { appendToInput("4") }
        button5.setOnClickListener { appendToInput("5") }
        button6.setOnClickListener { appendToInput("6") }
        button7.setOnClickListener { appendToInput("7") }
        button8.setOnClickListener { appendToInput("8") }
        button9.setOnClickListener { appendToInput("9") }
        button0.setOnClickListener { appendToInput("0") }
        button00.setOnClickListener { appendToInput("00") }
        buttontitik.setOnClickListener { appendToInput(".") }
        buttonTambah.setOnClickListener { appendToInput("+") }
        buttonKurang.setOnClickListener { appendToInput("-") }
        buttonKali.setOnClickListener { appendToInput("x") }
        buttonBagi.setOnClickListener { appendToInput("/") }

        buttonBackspace.setOnClickListener { removeLastCharacter() }
        buttonEquals.setOnClickListener { calculateResult() }
        return view
    }

    private fun appendToInput(value: String) {
        val currentInput = angka1.text.toString()
        angka1.setText(currentInput + value)
    }

    private fun removeLastCharacter() {
        val currentInput = angka1.text.toString()
        if (currentInput.isNotEmpty()) {
            angka1.setText(currentInput.substring(0, currentInput.length - 1))
        }
    }

    private fun calculateResult() {
        val input = angka1.text.toString()
        if (input.isNotEmpty()) {
            try {
                val result = eval(input)
                hasil.text = result.toString()
            } catch (e: Exception) {
                hasil.text = "error"
            }
        }
    }

    private fun eval(input: String): Number {
        return when {
            input.contains("+") -> {
                val parts = input.split("+")
                parts[0].toInt() + parts[1].toInt()
            }
            input.contains("-") -> {
                val parts = input.split("-")
                parts[0].toInt() - parts[1].toInt()
            }
            input.contains("x") -> {
                val parts = input.split("x")
                parts[0].toInt() * parts[1].toInt()
            }
            input.contains("/") -> {
                val parts = input.split("/")
                if (parts[1].toInt() != 0) {
                    parts[0].toInt() / parts[1].toInt()
                } else {
                    Double.NaN // Handle division by zero
                }
            }
            else -> input.toInt()
        }
    }
}