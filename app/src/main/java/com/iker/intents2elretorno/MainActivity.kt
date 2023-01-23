package com.iker.intents2elretorno

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : Activity() {

    lateinit var camara:Button
    lateinit var calculator:Button
    lateinit var resultadotext:TextView
    val REQUEST_IMAGE_CAPTURE = 1
    val RESULTADO = 1
    //Genera un número aleatorio hasta el 100
    var num1 = Math.floor(Math.random()*100).toInt()
    var num2 = Math.floor(Math.random()*100).toInt()
    var controlsuma = num1 + num2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        camara = findViewById(R.id.camara)
        calculator = findViewById(R.id.calculator)


        //Creamos el intent de la cámara que abrirá la aplicación
        val intentCamara = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        camara.setOnClickListener{
            startActivityForResult(intentCamara, REQUEST_IMAGE_CAPTURE)
        }

        val intentCalculator = Intent(this,CalculatorActivity::class.java)




        calculator.setOnClickListener{
            //añadimos números suma
            intentCalculator.putExtra("n1",num1)
            intentCalculator.putExtra("n2",num2)

            startActivityForResult(intentCalculator,RESULTADO)

        }



    }



    //Una vez la foto haya sido sacada y aceptada la pondrá en el imageview de la activity principal
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val imagen = findViewById<ImageView>(R.id.imagen)
        var resultadotext = findViewById<TextView>(R.id.textView)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            val imageBitmap = data.extras!!["data"] as Bitmap?
            imagen.setImageBitmap(imageBitmap)
        }

        //Una vez nos devuelve el resultcode de la calculadora comprueba si el resultado es el correcto.
        if(resultCode != Activity.RESULT_OK) return
        when(requestCode) {
            RESULTADO -> {
                if (data != null) {
                    if(data.getIntExtra("userresult",0)==controlsuma){
                        resultadotext.text="True"
                    }else{
                        resultadotext.text="False"
                    }
                }; }
    }
}}