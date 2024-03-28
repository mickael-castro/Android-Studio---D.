package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import kotlin.time.times
import kotlin.Double

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    lateinit var gasolina: TextView
    lateinit var alcool: TextView
    lateinit var textMsg: TextView

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("percentual",percentual)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        percentual=0.7
        if (savedInstanceState != null) {
            percentual=savedInstanceState.getDouble("percentual")
        }
        Log.d("PDM24", "No onCreate, $percentual")


        val btCalc: Button = findViewById(R.id.btCalcular)

        textMsg = findViewById(R.id.textMsg)
        gasolina = findViewById(R.id.edGasolina)
        alcool = findViewById(R.id.edAlcool)

        //btCalc.setBackgroundColor(Color.CYAN)
        btCalc.setOnClickListener(View.OnClickListener {
            val gasolinaValue = gasolina.text.toString().toDoubleOrNull() ?: 0.0
            val alcoolValue = alcool.text.toString().toDoubleOrNull() ?: 0.0
            val porcentagemValue = percentual
            //código do evento
            percentual=0.75
            textMsg.text="Já tenho o percentual"
            Log.d("PDM24","No btCalcular, $percentual")

            calcula(porcentagemValue, alcoolValue, gasolinaValue)
        })

    }

    fun calcula(porcentagem: Double, alcool: Double, gasolina: Double) {

        when{
            alcool <= gasolina * porcentagem -> textMsg.text="Vale a pena"
            else -> textMsg.text="Não vale a pena"

        }
    }

override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
}