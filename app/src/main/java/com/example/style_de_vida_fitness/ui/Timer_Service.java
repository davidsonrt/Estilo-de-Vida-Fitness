package com.example.style_de_vida_fitness.ui;



import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Timer_Service extends Service {

    public static String str_receiver = "com.countdowntimerservice.receiver";
    public static String str_testing;
    private Handler mHandler = new Handler();

    SharedPreferences mpref;
    SharedPreferences.Editor mEditor;

    private Timer mTimer = null;
    public static final long NOTIFY_INTERVAL = 1000;
    private static final long MILLIS_IN_SEC = 1000L;
    private static final int SECS_IN_MIN = 60;
    Intent intent;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mpref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mEditor = mpref.edit();

        mTimer = new Timer();
        mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 5, NOTIFY_INTERVAL);
        intent = new Intent(str_receiver);
    }


    class TimeDisplayTimerTask extends TimerTask {

        @Override
        public void run() {
            mHandler.post(new Runnable() {

                @Override
                public void run() {


                    twoDatesBetweenTime();

                }

            });
        }

    }

    public String twoDatesBetweenTime() {



        try {


            long diff = 0;
            long int_hours = mpref.getLong("hours", diff);
            long seconds = (System.currentTimeMillis() - int_hours) / MILLIS_IN_SEC;
            String str = String.format("%02d:%02d", seconds / SECS_IN_MIN, seconds % SECS_IN_MIN);
            if (int_hours > 0) {
                 str_testing = str;

                Log.e("TIME", str_testing);

                fn_update(str_testing);
            } else {
                mEditor.putBoolean("finish", true).commit();
                mTimer.cancel();
            }
        }catch (Exception e){
            mTimer.cancel();
            mTimer.purge();


        }

        return "";

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("Service finish","Finish");
    }

    private void fn_update(String str_time){

        intent.putExtra("time",str_time);
        sendBroadcast(intent);
    }
}
