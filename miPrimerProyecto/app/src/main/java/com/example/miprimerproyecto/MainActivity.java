package com.example.miprimerproyecto;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// Import correcto basado en el namespace del build.gradle
import com.example.miprimerproyecto.R;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    @Override
    protected void onPause() {
        detener();
        super.onPause();
    }

    @Override
    protected void onResume() {
        iniciar();
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorProximidad();
    }

    private void iniciar() {
        if (sensorManager != null && sensorEventListener != null && sensor != null) {
            sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    private void detener() {
        if (sensorManager != null && sensorEventListener != null) {
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    private void sensorProximidad() {
        tempVal = findViewById(R.id.lblSensorProximidad);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (sensor == null) {
            if (tempVal != null) {
                tempVal.setText("No dispones del sensor de proximidad");
            }
            return;
        }

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                double valor = sensorEvent.values[0];
                if (tempVal != null) {
                    tempVal.setText("Proximidad: " + valor);
                }

                int color = Color.BLACK;
                if (valor <= 4) {
                    color = Color.WHITE;
                }
                getWindow().getDecorView().setBackgroundColor(color);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }


        };
    }
}
