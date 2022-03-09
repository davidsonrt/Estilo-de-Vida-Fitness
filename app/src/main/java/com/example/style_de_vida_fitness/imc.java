package com.example.style_de_vida_fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class imc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        setTitle("IMC");
        CardView somar = (CardView) findViewById(R.id.idcalcular);
        somar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText altura1 = (EditText) findViewById(R.id.idaltura);
                EditText peso1 = (EditText) findViewById(R.id.idpeso);
                TextView resultado = (TextView) findViewById(R.id.idresposta);
                float altura = Float.parseFloat(altura1.getText().toString());
                float peso = Float.parseFloat(peso1.getText().toString());
                float res = 0;
                res = (peso / (altura * altura));

                if(res < 18.5 ) {
                    resultado.setText("Resultado: " + res + " Classificação magreza");
                }else if(res<=24.9 & res >=18.5){
                    resultado.setText("Resultado: " + res + " Classificação normal");
                }else if(res <= 29.9 & res >= 25.0){
                    resultado.setText("Resultado: " + res + " Classificação sobrepeso");
                }else if(res <= 39.9& res >= 30.0){
                    resultado.setText("Resultado: " + res + " Classificação obesidade");
                }else if(res >= 40.0){
                    resultado.setText("Resultado: " + res + " Classificação obesidade grave");
                }

            }
        });

    }}