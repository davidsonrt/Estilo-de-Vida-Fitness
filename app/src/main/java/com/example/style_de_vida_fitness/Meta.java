package com.example.style_de_vida_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Meta extends AppCompatActivity {
    DBHelper db;
    RadioButton massa_mus, emagre, resis1;
    String met, ant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meta);
        db = new DBHelper(this);
        massa_mus = (RadioButton) findViewById(R.id.idmassa);
        emagre = (RadioButton) findViewById(R.id.idemagrecer);
        resis1 = (RadioButton) findViewById(R.id.idresistencia);
        TextView ant = findViewById(R.id.textView67);
        String nd = " ";
        String meta1 = db.buscameta(nd);
        ant.setText("Sua meta é " + meta1);


    }

    public void editarmeta(View v) {
        // a classe derivada de SQLiteOpenHelper
        String nd = " ";
        long res4 = 0;
        TextView ant = findViewById(R.id.textView67);
        if (massa_mus.isChecked()) {
            met = "Ganhar Massa Muscular";
            String nome1 = db.buscamnome(nd);
            res4 = db.alterameta(nome1, met);
            ant.setText("Sua meta é " + met);
            Toast.makeText(Meta.this,
                    "meta alterada com sucesso", Toast.LENGTH_LONG).show();
        } else if (resis1.isChecked()) {
            met = "Melhorar Resistência Física";
            String nome1 = db.buscamnome(nd);
            res4 = db.alterameta(nome1, met);
            ant.setText("Sua meta é " + met);
            Toast.makeText(Meta.this,
                    "meta alterada com sucesso", Toast.LENGTH_LONG).show();
        } else if (emagre.isChecked()) {
            met = "Emagrecer";
            String nome1 = db.buscamnome(nd);
            res4 = db.alterameta(nome1, met);
            ant.setText("Sua meta é " + met);
            Toast.makeText(Meta.this,
                    "meta alterada com sucesso", Toast.LENGTH_LONG).show();
        } else if (!massa_mus.isChecked() & !emagre.isChecked() & !resis1.isChecked()) {


            Toast.makeText(Meta.this, "Você deve selecionar uma meta", Toast.LENGTH_SHORT).show();

        }
    }
}