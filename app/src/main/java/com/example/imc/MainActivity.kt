package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Atributos
        var button=findViewById<View>(R.id.button) as Button
        var Altura=findViewById<View>(R.id.Altura) as TextView
        var Peso=findViewById<View>(R.id.Peso) as TextView

        //Metodo del boton, al momento de darle click realizara los calculos
        button.setOnClickListener(){


            //Guardar datos para la siguiente actividad
           val intent = Intent(this@MainActivity, Resultados::class.java)
            //Parametros para calcular
            var AlturaM : Double = Altura.text.toString().toDouble()/1000
            val PesoKG : Double  =Peso.text.toString().toDouble()*0.453592
            //Formula de IMC
            val PesoIdeal : Double =PesoKG/(AlturaM*AlturaM)

            val b : Bundle = Bundle()
            b.putDouble("PesoIdeal",PesoIdeal)
            intent.putExtras(b)

            startActivity(intent)
        }
        //Si el boton se mantiene presionado mostrara la formula de IMC
        button.setOnLongClickListener(){
            Toast.makeText(this@MainActivity, "La formula es KG/Altura^2", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true

        }
    }
}
