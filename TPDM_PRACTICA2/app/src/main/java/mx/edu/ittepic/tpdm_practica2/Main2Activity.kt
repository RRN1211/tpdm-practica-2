package mx.edu.ittepic.tpdm_practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class Main2Activity : AppCompatActivity() {
    var layouPR : LinearLayout?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        vector?.setOnClickListener {
            if (vector?.isChecked == true) {
                layouPR?.visibility = View.GONE
            }
        }
        matriz?.setOnClickListener {
            if (matriz?.isChecked == true) {
                layouPR?.visibility = View.VISIBLE
            }
        }
    }
}
