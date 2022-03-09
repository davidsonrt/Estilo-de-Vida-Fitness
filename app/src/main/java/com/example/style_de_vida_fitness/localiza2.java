package com.example.style_de_vida_fitness;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class localiza2 extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private FusedLocationProviderClient fusedLocationClient;
    private GoogleApiClient googleApiClient;
    private Button btn;
    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this) //Be aware of state of the connection
                .addOnConnectionFailedListener(this) //Be aware of failures
                .build();

        //Tentando conexão com o Google API. Se a tentativa for bem sucessidade, o método onConnected() será chamado, senão, o método onConnectionFailed() será chamado.
        googleApiClient.connect();

    }

    @Override
    protected void onStop() {
        super.onStop();
        pararConexaoComGoogleApi();
    }

    public void pararConexaoComGoogleApi() {
        //Verificando se está conectado para então cancelar a conexão!
        if (googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
    }

    /**
     * Depois que o método connect() for chamado, esse método será chamado de forma assíncrona caso a conexão seja bem sucedida.
     *
     * @param bundle
     */
    @Override
    public void onConnected(Bundle bundle) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        btn = findViewById(R.id.location_btn);
        textview = findViewById(R.id.location_text);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        //get the location here
                        fusedLocationClient.getLastLocation()
                                .addOnSuccessListener(new OnSuccessListener<Location>() {
                                    @Override
                                    public void onSuccess(Location location) {
                                        if (location != null) {
                                            Double lat = location.getLatitude();
                                            Double longt = location.getLongitude();

                                            textview.setText(lat + " , " + longt);
                                            Toast.makeText(localiza2.this, "Sucess", Toast.LENGTH_SHORT);


                                        }
                                    }
                                });
                    } else {

                    }
                }
                /**
                 * Esse método é chamado quando o client está temporariamente desconectado. Isso pode acontecer quando houve uma falha ou problema com o serviço que faça com que o client seja desligado.
                 * Nesse estado, todas as requisições e listeners são cancelados.
                 * Não se preocupe em tentar reestabelecer a conexão, pois isso acontecerá automaticamente.
                 * As aplicações devem desabilitar recursos visuais que estejam relacionados com o uso dos serviços e habilitá-los novamente quando o método onConnected() for chamado, indicando reestabelecimento da conexão.
                 *
                 /**
                 * Método chamado quando um erro de conexão acontece e não é possível acessar os serviços da Google Service.
                 *
                 * @param connectionResult
                 */

            }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}