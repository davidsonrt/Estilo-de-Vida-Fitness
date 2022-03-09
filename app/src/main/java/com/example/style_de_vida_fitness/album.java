package com.example.style_de_vida_fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class album extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
    }

    public void belim1(View v){
        Intent myIntent = new Intent(getApplicationContext(), berlim.class);
        startActivity(myIntent);

    } public void dont1(View v){
        Intent myIntent = new Intent(getApplicationContext(), dont.class);
        startActivity(myIntent);
    }
    public void four1(View v){
        Intent myIntent = new Intent(getApplicationContext(), four.class);
        startActivity(myIntent);
    }

}