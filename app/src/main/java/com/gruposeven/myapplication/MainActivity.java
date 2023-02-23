package com.gruposeven.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnconvertir;

    Spinner spn;

    TextView txtresulta;

    conversores miConversor = new conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnconvertir = (Button) findViewById(R.id.btnconvertir);
        btnconvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtresulta = (TextView) findViewById(R.id.txtcantidad);
                double cantidad = Double.parseDouble(txtresulta.getText().toString());

                spn = findViewById(R.id.spn1);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spn2);
                int a = spn.getSelectedItemPosition();

                txtresulta = findViewById(R.id.txtresultado);
                txtresulta.setText("Respuesta: "+ miConversor.convertir(0, de, a, cantidad));

            }
        });





    }
}

class conversores{
    double[][] money = {
            {1, 7.84, 24.63, 36.51, 581.78, 8.75, 0.93, 130.54, 82.52, 0.82},//monedas

    };
    public double convertir(int opcion, int de, int a, double cantidad){
        return money[opcion][a] / money[opcion][de] * cantidad;
    }
}