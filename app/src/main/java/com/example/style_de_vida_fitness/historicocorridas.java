package com.example.style_de_vida_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.style_de_vida_fitness.ui.Timer_Service;

import java.text.DecimalFormat;

public class historicocorridas extends AppCompatActivity {
    private TextView resulTextView;
    private TextView resulTextViewmedia;
    private TextView resulTextViewmax;
    private TextView resulTextViewcrono;
    private TextView resulTextViewdia;
    private TextView resulTextView2;
    private TextView resulTextViewmedia2;
    private TextView resulTextViewmax2;
    private TextView resulTextViewcrono2;
    private TextView resulTextViewdia2;
    private static final int SECS_IN_MIN = 60;
    SQLiteHelper sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historicocorridas);
        sb = new SQLiteHelper(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //corrida mais longa
        resulTextView = (TextView) findViewById(R.id.resultkm);
        resulTextViewmedia = (TextView) findViewById(R.id.resulmedia);
        resulTextViewmax = (TextView) findViewById(R.id.resulmax);
        resulTextViewcrono = (TextView) findViewById(R.id.resulcrono);
        resulTextViewdia = (TextView) findViewById(R.id.resuldia);
        // vel media mais rapida
        resulTextView2 = (TextView) findViewById(R.id.resultkm2);
        resulTextViewmedia2 = (TextView) findViewById(R.id.resulmedia2);
        resulTextViewmax2 = (TextView) findViewById(R.id.resulmax2);
        resulTextViewcrono2 = (TextView) findViewById(R.id.resulcrono2);
        resulTextViewdia2 = (TextView) findViewById(R.id.resuldia2);
try {
    // corrida mais longa
    String res = "";
    res = sb.hiskm(res);
    float f = Float.valueOf(res).floatValue();
    DecimalFormat df = new DecimalFormat("0.00");
    resulTextView.setText("Distância(km): " + df.format(f));

    String rescrono = "";
    rescrono = sb.hiscrono(rescrono);
    long fcrono = Long.valueOf(rescrono).longValue();
    String str = String.format("%02d:%02d", fcrono / SECS_IN_MIN, fcrono % SECS_IN_MIN);
    resulTextViewcrono.setText("Tempo: " + str);

    String resmedia = "";
    resmedia = sb.hismedia(resmedia);
    float fm = Float.valueOf(resmedia).floatValue();
    DecimalFormat dfm = new DecimalFormat("0.00");
    resulTextViewmedia.setText("Velocidade Média: " + dfm.format(fm));

    String resmax = "";
    resmax = sb.hismax(resmax);
    float fmax = Float.valueOf(resmax).floatValue();
    DecimalFormat dfmax = new DecimalFormat("0.00");
    resulTextViewmax.setText("Velocidade Máxima: " + dfmax.format(fmax));

    String resdia = "";
    resdia = sb.hisdia(resdia);
    resulTextViewdia.setText(resdia);
    // corrida mais rapida pela velocida media

    String res2 = "";
    res2 = sb.hiskm2(res2);
    float f2 = Float.valueOf(res2).floatValue();
    DecimalFormat df2 = new DecimalFormat("0.00");
    resulTextView2.setText("Distância(km): " + df2.format(f2));

    String rescrono2 = "";
    rescrono2 = sb.hiscrono2(rescrono2);
    long fcrono2 = Long.valueOf(rescrono2).longValue();
    String str2 = String.format("%02d:%02d", fcrono2 / SECS_IN_MIN, fcrono2 % SECS_IN_MIN);
    resulTextViewcrono2.setText("Tempo: " + str2);

    String resmedia2 = "";
    resmedia2 = sb.hismedia2(resmedia2);
    float fm2 = Float.valueOf(resmedia2).floatValue();
    DecimalFormat dfm2 = new DecimalFormat("0.00");
    resulTextViewmedia2.setText("Velocidade Média: " + dfm2.format(fm2));

    String resmax2 = "";
    resmax2 = sb.hismax2(resmax2);
    float fmax2 = Float.valueOf(resmax2).floatValue();
    DecimalFormat dfmax2 = new DecimalFormat("0.00");
    resulTextViewmax2.setText("Velocidade Máxima: " + dfmax2.format(fmax2));

    String resdia2 = "";
    resdia2 = sb.hisdia2(resdia2);
    resulTextViewdia2.setText(resdia2);

}catch (Exception e){

}}
}