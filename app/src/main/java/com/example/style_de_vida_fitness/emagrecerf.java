package com.example.style_de_vida_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.MediaController;
import android.widget.VideoView;

public class emagrecerf extends AppCompatActivity {
    private Chronometer chronometerj;
    private boolean running;
    private long pauseoffset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emagrecerf);
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

      /*  VideoView video = (VideoView) findViewById(R.id.videoemagrecerf);
        Uri src = Uri.parse("android.resource://com.example.style_de_vida_fitness/");
        video.setVideoURI(src);
        video.setMediaController(new MediaController(this));*/

}