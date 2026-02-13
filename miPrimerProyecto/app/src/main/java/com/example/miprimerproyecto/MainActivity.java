package com.example.miprimerproyecto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
     TextView tempVal;
     Button btn;
     RadioGroup radioGroup;
     RadioButton opt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(v->calcular());
    }
    private void calcular(){
        tempVal = findViewById(R.id.txtNum1);
        Double num1 = Double.parseDouble(tempVal.getText().toString());

        tempVal = findViewById(R.id.txtNum2);
        Double num2 = Double.parseDouble(tempVal.getText().toString());

        double respuesta = 0;

        radioGroup = findViewById(R.id.optOpciones);
        if(radioGroup.getCheckedRadioButtonId()==R.id.optSuma) {
            respuesta = num1 + num2;
        }
        if(radioGroup.getCheckedRadioButtonId()==R.id.optResta) {
            respuesta = num1 - num2;
        }
        if(radioGroup.getCheckedRadioButtonId()==R.id.optMultiplicar) {
            respuesta = num1 * num2;
        }
        if(radioGroup.getCheckedRadioButtonId()==R.id.optDividir) {
            respuesta = num1 / num2;
        }
        tempVal = findViewById(R.id.lblRespuesta);
        tempVal.setText("Respuesta: "+ respuesta);
    }
}
