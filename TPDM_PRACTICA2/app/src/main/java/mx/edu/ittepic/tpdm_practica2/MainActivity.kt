package mx.edu.ittepic.tpdm_practica2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var celdas: EditText? = null
    var renglones: EditText? = null
    var layoRenglones: LinearLayout? = null
    var vector: RadioButton? = null
    var matriz: RadioButton? = null
    var menulist: ListView? = null
    var layocampos: LinearLayout? = null
    var textren: TextView? = null
    var celda = 0
    var renglon = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        celdas = findViewById(R.id.celdas)
        layoRenglones = findViewById(R.id.layoRenglones)
        vector = findViewById(R.id.vector)
        matriz = findViewById(R.id.matriz)
        menulist = findViewById(R.id.menulist)
        layocampos = findViewById(R.id.layocampos)
        renglones = findViewById(R.id.renglones)
        textren = findViewById(R.id.textren)

        vector?.setOnClickListener {
            if (vector?.isChecked == true) {
                layoRenglones?.visibility = View.GONE
                textren?.visibility = View.GONE
                renglones?.visibility = View.GONE
            }
        }
        matriz?.setOnClickListener {
            if (matriz?.isChecked == true) {
                layoRenglones?.visibility = View.VISIBLE
                textren?.visibility = View.VISIBLE
                renglones?.visibility = View.VISIBLE
            }
        }
        menulist?.setOnItemClickListener { adapterView, view, i, l ->
            when (i) {
                1 -> mostrarValores()
                2 -> acercaDe()
                3 -> finish()
            }
        }
    }
    fun capturarValores(){
        if (vector?.isChecked == true) {
            if(celdas?.text.toString().isEmpty()){
                val alerta=AlertDialog.Builder(this)
                alerta.setIcon(android.R.drawable.ic_dialog_info).setTitle("Error").setMessage("Este campo no puede ser vacio").show()
            }
            else{
                var otraActivity = Intent(this,Main2Activity::class.java)
                celda = celdas?.text.toString().toInt()
                otraActivity.putExtra("cel",celda)
                startActivity(otraActivity)
            }
        }
        if (matriz?.isChecked == true) {
            if(renglones?.text.toString().isEmpty() && celdas?.text.toString().isEmpty()){
                val alerta=AlertDialog.Builder(this)
                alerta.setIcon(android.R.drawable.ic_dialog_info).setTitle("Error").setMessage("Celdas y renglones no pueden estar vacios").show()
            }
            else{
                var otraActivity = Intent(this,Main2Activity::class.java)
                celda = celdas?.text.toString().toInt()
                renglon = renglones.toString().toInt()
                otraActivity.putExtra("cel",celda)
                otraActivity.putExtra("ren",renglon)
                startActivity(otraActivity)
            }
        }
    }
    fun mostrarValores(){
        var otraActivity = Intent(this,Main3Activity::class.java)
        startActivity(otraActivity)
    }
    fun acercaDe(){
        val alerta = AlertDialog.Builder(this)
        alerta.setIcon(android.R.drawable.ic_dialog_alert).setTitle("Acerca de...").setMessage("(C) Roman Rivera Navarrete").setPositiveButton("Aceptar"){dialogInterface, i ->
        }.show()
    }
    }


