package com.example.style_de_vida_fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class contatos extends AppCompatActivity {
    CardView bt_whats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
        bt_whats=(CardView)findViewById(R.id.btwhat);

    }
    public void abrirwhats(View v){
        String URL = "https://api.whatsapp.com/send?phone=+5511957136508";
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setData(Uri.parse(URL));
        startActivity(myIntent);

    }  public void abrirwhats2(View v){
        String URL = "https://api.whatsapp.com/send?phone=+5511967199333";
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setData(Uri.parse(URL));
        startActivity(myIntent);

    } public void abrirwhats3(View v){
        String URL = "https://api.whatsapp.com/send?phone=+5511983277776";
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setData(Uri.parse(URL));
        startActivity(myIntent);

    } public void abriemail(View v){
        String URL = "mailto:davidsonribeiro014@gmail.com?subject=Questions";
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setData(Uri.parse(URL));
        startActivity(myIntent);

    }
    public void abriemail3(View v){
        String URL = "mailto:danielvespoli1@gmail.com?subject=Questions";
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setData(Uri.parse(URL));
        startActivity(myIntent);

    }
    public void abriemail2(View v){
        String URL = "mailto:davidribeirotorres@gmail.com?subject=Questions";
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setData(Uri.parse(URL));
        startActivity(myIntent);

    }
}