package com.aromas.wifi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Lista de las 3 personas permitidas (Tú y tus 2 amigas)
    // Aquí luego pondremos las IDs reales de sus teléfonos
    val listaPermitida = listOf("Móvil_Líder", "Amiga_1", "Amiga_2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnScan = findViewById<Button>(R.id.btnScan)
        val userCounter = findViewById<TextView>(R.id.userCounter)

        btnScan.setOnClickListener {
            // Acción al pulsar el botón dorado
            Toast.makeText(this, "Buscando red Wi-Fi segura...", Toast.LENGTH_SHORT).show()
            
            // Simulación de control de límite
            if (listaPermitida.size <= 3) {
                userCounter.text = "Conectados: ${listaPermitida.size} / 3"
                activarModoNano()
            } else {
                Toast.makeText(this, "Límite alcanzado. Solo 3 personas.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun activarModoNano() {
        // Aquí va la lógica para forzar la conexión a la primera red abierta
        // y bloquear los datos móviles para no gastar dinero
        Toast.makeText(this, "Modo Nano Activo. Datos Protegidos.", Toast.LENGTH_LONG).show()
    }
}
