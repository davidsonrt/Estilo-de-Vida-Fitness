package com.example.style_de_vida_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class massam extends AppCompatActivity {
    private Chronometer chronometerj;
    private boolean running;
    private long pauseoffset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massam);
        setTitle("Treinos");
        chronometerj =(Chronometer) findViewById(R.id.cronometro);
        chronometerj.setFormat("Time:%");
        chronometerj.setBase(SystemClock.elapsedRealtime());

        chronometerj.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime()- chronometer.getBase())>=600000){
                    chronometer.setBase(SystemClock.elapsedRealtime());

                }
            }
        });

    }

    public void startChronometer(View s){
        if(!running){
            chronometerj.setBase(SystemClock.elapsedRealtime()-pauseoffset);
            chronometerj.start();
            running=true;
        }

    }


    public void pauseChronometer(View p){
        if(running){
            chronometerj.stop();
            pauseoffset=SystemClock.elapsedRealtime()-chronometerj.getBase();
            running=false;

        }
    }

    public void stopChronometer(View s){
        if(running){
            chronometerj.stop();
            pauseoffset=SystemClock.elapsedRealtime()-chronometerj.getBase();
            running=false;

        }
        chronometerj.setBase(SystemClock.elapsedRealtime());
        pauseoffset=0;
    }

}
