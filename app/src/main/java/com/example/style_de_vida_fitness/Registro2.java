package com.example.style_de_vida_fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Registro2 extends AppCompatActivity {

    RadioButton massa_mus,emagre,resis;
    CardView bt_registrar2;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
        db = new DBHelper(this);


        massa_mus = (RadioButton) findViewById(R.id.idmassa2);
        emagre = (RadioButton) findViewById(R.id.idemagrecer2);
        resis = (RadioButton) findViewById(R.id.idresistencia2);
        bt_registrar2 = (CardView) findViewById(R.id.idregistrar2);

            bt_registrar2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
            String met ="";
            if(!massa_mus.isChecked() & !emagre.isChecked() & !resis.isChecked()){
                Toast.makeText(Registro2.this,"Você deve selecionar uma meta", Toast.LENGTH_SHORT).show();
            }else{
            if(massa_mus.isChecked()){
                met= "Ganhar Massa Muscular";
            }
            else if(emagre.isChecked()){
                met= "Emagrecer";
            }
            else if(resis.isChecked()){
                met= "Melhorar Resistência Física";
            }
                    Bundle extras = getIntent().getExtras();
                    if (extras != null) {

                        String nome = extras.getString("nome");
                        String sexo = extras.getString("sexo");

                        long res = db.CriarUtilizador(nome, met,sexo);

            if (res > 0) {
                Toast.makeText(getApplicationContext(), "Registro OK", Toast.LENGTH_SHORT).show();
                Intent myIntenti = new Intent(getApplicationContext(), Treine_ao_ar_livre.class);
                myIntenti.putExtra("nome", nome);
                myIntenti.putExtra("sexo", sexo);
                myIntenti.putExtra("meta", met);
                startActivity(myIntenti);
                Registro2.this.finish();
            }}}} });}}