package com.iker.intents2elretorno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var camara:Button
    lateinit var calculator:Button
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        camara = findViewById(R.id.camara)
        calculator = findViewById(R.id.calculator)

        val intentCamara = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        camara.setOnClickListener({
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        })

        val intentCalculator = Intent(this,CalculatorActivity::class.java)

        calculator.setOnClickListener({

        })



    }
}