package com.iker.intents2elretorno

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    lateinit var suma:TextView
    lateinit var resultado:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        suma = findViewById(R.id.operacion)
        resultado = findViewById(R.id.editTextNumber)


        val intent = getIntent()

        val valor1 = intent.getIntExtra("n1",0)
        val valor2 = intent.getIntExtra("n2",0)


        suma.text = valor1.toString() +" + " + valor2.toString()

        resultado.onSubmit {
            val numresultado = resultado.text.toString().toInt()
            intent.putExtra("userresult",numresultado)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }


    }
    fun EditText.onSubmit(func: () -> Unit) {
        setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                func()
            }

            true

        }
    }
}