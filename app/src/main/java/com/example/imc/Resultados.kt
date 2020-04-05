package com.example.imc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Resultados : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        //Atributos
        var Final=findViewById<View>(R.id.Final) as TextView
        var Promo=findViewById<View>(R.id.promocion) as TextView
        var Foto=findViewById<View>(R.id.imageView) as ImageView

        var bundle = intent.extras

        //Donde guarda los datos para pasar a la siguiente actividad
        if (bundle != null) {
            var Final2=(Math.round((bundle.getDouble("PesoIdeal")/100.00)*100.0)/100.0)

            Final.text=Final2.toString()
            //Si el resultado es menor que 18 indicar que la persona se encuentra en bajo peso
            if(Final2<18)
            {
                Promo.text="Bajo Peso"
                Foto.setImageResource(R.mipmap.bajo)
            }
            else
            {
                //Si el resultado esta entre 18 y 25, la persona se encuentra en su peso normal
                if(Final2>18 && Final2<25)
                {
                   Promo.text="Normal"
                    Foto.setImageResource(R.mipmap.normal)
                }
                else
                {
                    if(Final2>25 && Final2<30)
                    {
                        //Si el resultado esta entre 25 y 30, la persona se encuentra en sobrepeso
                        Promo.text="Sobrepeso"
                        Foto.setImageResource(R.mipmap.sobrepeso)
                    }
                    else
                    {
                        //Si el resultado es mayor que 30, la persona se encuentra en obesidad
                        if(Final2>30)
                        {
                            Promo.text="Obeso"
                            Foto.setImageResource(R.mipmap.obesidad)
                        }
                    }
                }

                }


        }



        }





}
