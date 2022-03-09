package com.example.style_de_vida_fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.style_de_vida_fitness.ui.gallery.GalleryFragment;

public class MainActivity extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("");
        db = new DBHelper(this);
        String oi = "ERRO";
        String res = db.verificarUtilizador(oi);
        if (res.equals("OK")) {
            Intent myIntent = new Intent(getApplicationContext(), Treine_ao_ar_livre.class);
            startActivity(myIntent);
            MainActivity.this.finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CardView btnentrar = (CardView) findViewById(R.id.idacessar);
        btnentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //tudo ok
                        Intent myIntenti = new Intent(getApplicationContext(), RegistarActivity.class);
                        startActivity(myIntenti);
                MainActivity.this.finish();

            }
        });}}