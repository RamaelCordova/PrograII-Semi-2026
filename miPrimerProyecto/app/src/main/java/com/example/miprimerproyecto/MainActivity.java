package com.example.miprimerproyecto;

import android.os.Bundle;import android.widget.Button;
import android.widget.EditText; // Cambiado a EditText para capturar datos
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast; // Para mostrar errores

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Declaramos las variables de los controles
    EditText txtNum1, txtNum2;
    Button btn;
    Spinner spn;
    TextView lblRespuesta;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos los controles una sola vez aquí
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        btn = findViewById(R.id.btnCalcular);
        spn = findViewById(R.id.cboOpciones);
        lblRespuesta = findViewById(R.id.lblRespuesta);

        btn.setOnClickListener(v -> calcular());
    }

    private void calcular() {
        try {
            // Obtenemos los valores de los cuadros de texto
            double num1 = Double.parseDouble(txtNum1.getText().toString());
            double num2 = Double.parseDouble(txtNum2.getText().toString());
            double respuesta = 0;

            // Evaluamos la opción seleccionada en el Spinner
            switch (spn.getSelectedItemPosition()) {
                case 0: // Suma
                    respuesta = num1 + num2;
                    break;
                case 1: // Resta
                    respuesta = num1 - num2;
                    break;
                case 2: // Multiplicacion
                    respuesta = num1 * num2;
                    break;
                case 3: // Division
                    if (num2 != 0) {
                        respuesta = num1 / num2;
                    } else {
                        lblRespuesta.setText("Error: Div entre 0");
                        return;
                    }
                    break;
            }
            // Mostramos el resultado
            lblRespuesta.setText("Respuesta: " + respuesta);

        } catch (Exception e) {
            // Si el usuario dejó un campo vacío, mostramos un mensaje en lugar de cerrar la App
            Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_SHORT).show();
        }
    }
}