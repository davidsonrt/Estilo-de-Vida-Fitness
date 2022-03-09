package com.example.style_de_vida_fitness;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class Utils {

    static final String KEY_REQUESTING_LOCATION_UPDATES = "requesting_location_updates";

    /**
     * Returns true if requesting location updates, otherwise returns false.
     *
     * @param context The {@link Context}.
     */
    static boolean requestingLocationUpdates(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_REQUESTING_LOCATION_UPDATES, false);
    }

    /**
     * Stores the location updates state in SharedPreferences.
     * @param requestingLocationUpdates The location updates state.
     */
    static void setRequestingLocationUpdates(Context context, boolean requestingLocationUpdates) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_REQUESTING_LOCATION_UPDATES, requestingLocationUpdates)
                .apply();
    }

    /**
     * Returns the {@code location} object as a human readable string.
     * @param location  The {@link Location}.
     *
     */
    public static float metros=0,km=0, speed=0, max=0,vel=0,media=0,se=0;
    public static String resultado="";
    public static  ArrayList<Float> valores = new ArrayList<Float>();
    public static long data1=0,data2;
    public static final long MILLIS_IN_SEC = 1000L;
    public static String  getLocationText(Location location) {

            se=location.getSpeed();
       se= (se * 3600) / 1000;
            if(se>1) {
                speed = location.getSpeed();
                metros = (speed * 48)/10;
                km = (metros/1000) + km;
                speed = (speed * 3600) / 1000;

                if (vel < speed) {
                    max = speed;
                    vel = speed;
                }

                float total = 0;

                valores.add(speed);
                int tam = valores.size();
                for (int i = 0; i < valores.size(); i++) {
                    total = total + valores.get(i);


                }

                media = total / tam;
                resultado = "Distância (Km): " + km + "\nVelocidade: " + speed + "\nVelocidade Máxima: " + max;

            }else{
                speed =0;
            }
        return location == null ? "Localização desligada! você deve ligar a localização do dispositivo" :
                "" + resultado + ""; }

   public static double getLocationText2(double location) {
        metros=0; speed=0;max=0;vel=0;km=0;media=0;valores.clear();
        return 0.00;
    }
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( cm != null ) {
            NetworkInfo ni = cm.getActiveNetworkInfo();

            return ni != null && ni.isConnected();
        }

        return false;
    }

    public static long getLocationTitle(Context context) {
        if(data1==0){
          data1=System.currentTimeMillis();

        }else{
            data2=0;
            data2 =System.currentTimeMillis();
            data2=(data2-data1)/ MILLIS_IN_SEC;


            data1=0;
        }
        return data2;
    }
    public static String datacorrida(Context context) {

        return DateFormat.getDateTimeInstance().format(new Date());
    }
}
