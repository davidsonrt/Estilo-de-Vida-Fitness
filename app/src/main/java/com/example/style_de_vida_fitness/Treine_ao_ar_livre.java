package com.example.style_de_vida_fitness;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class Treine_ao_ar_livre extends AppCompatActivity {
    DBHelper db;
    SQLiteHelper sb;

    String[] appPermissoes = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    public static final int CODIGO_PERMISSOES_REQUERIDAS = 1;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treine_ao_ar_livre);


        db=new DBHelper (this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu2 ID as a set of Ids because each
        // menu2 should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            TextView nome2 = findViewById(R.id.nome_usua);

            String nd = " ";

            String nome1 = db.buscamnome(nd);




            nome2.setText(nome1);



        // Inflate the menu2; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.treine_ao_ar_livre, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void abrirImc(View v){

            Intent myIntent = new Intent(getApplicationContext(), imc.class);
            startActivity(myIntent);

        }
    public void VerificarDietas (View v){
        String nd = " ";
        String meta = db.buscameta(nd);
             if (meta.equals("Emagrecer")){
                    Intent myIntent = new Intent(getApplicationContext(), dietaemagrecer.class);
                    startActivity(myIntent);

                }
                else if (meta.equals("Ganhar Massa Muscular")){
                    Intent myIntent = new Intent(getApplicationContext(), dietaganhomassa.class);
                    startActivity(myIntent);
                }
                else if (meta.equals("Melhorar Resistência Física")){
                    Intent myIntent = new Intent(getApplicationContext(), dietaresistencia.class);
                    startActivity(myIntent);
                }
        }

    public void Verificar (View v){
        String nd = " ";
        String genero = db.buscaSEXO(nd);
        String meta = db.buscameta(nd);

        if(genero.equals("m") & meta.equals("Emagrecer")){
                Intent myIntent = new Intent(getApplicationContext(), emagrecem.class);
                startActivity(myIntent);
        }
            else if (genero.equals("m") & meta.equals("Ganhar Massa Muscular")){
                Intent myIntent = new Intent(getApplicationContext(), massam.class);
                startActivity(myIntent);
            }
          else if(genero.equals("f") & meta.equals("Emagrecer")) {
                Intent myIntent = new Intent(getApplicationContext(), emagrecerf.class);
                startActivity(myIntent);


            } else if (genero.equals("f") & meta.equals("Ganhar Massa Muscular")) {
                Intent myIntent = new Intent(getApplicationContext(), massaf.class);
                startActivity(myIntent);

            } else if (genero.equals("f") & meta.equals("Melhorar Resistência Física")) {
                Intent myIntent = new Intent(getApplicationContext(), melhorf.class);
                startActivity(myIntent);

        }
        else if (genero.equals("m") & meta.equals("Melhorar Resistência Física")) {
            Intent myIntent = new Intent(getApplicationContext(), melhorm.class);
            startActivity(myIntent);

        }
        }


    public void abrirMaps(View v){
        if (verificarPermissoes()) {
            //iniciar o aplicativo
            Intent myIntent = new Intent(getApplicationContext(), MapsActivity.class);
            boolean veri;
            veri= Utils.isConnected(getApplicationContext());
            if( veri==true){




                LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);

// Verifica se o GPS está ativo
                boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);

// Caso não esteja ativo abre um novo diálogo com as configurações para
// realizar se ativamento
                if (!enabled) {

                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    Intent callGPSSettingIntent = new Intent(
                                            android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                    startActivity(callGPSSettingIntent);
                                    break;
                            }
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    AlertDialog mNoGpsDialog = builder.setMessage("Por favor ative seu GPS para acessar o mapa.")
                            .setPositiveButton("Ativar", dialogClickListener)
                            .create();
                    mNoGpsDialog.show();
                }else{
                    startActivity(myIntent);  }


            }
            else{
                Toast.makeText(Treine_ao_ar_livre.this,"Sem acesso a internet, não é possível utilizar esta função.",
                        Toast.LENGTH_SHORT).show();

            }


        } else {
            //   alert("Permita o uso do gps para melhorar o uso do app");
        }

        

    }
    public boolean verificarPermissoes() {
        List<String> permissoesRequeridas = new ArrayList<>();

        for (String permissao : appPermissoes) {
            if (ContextCompat.checkSelfPermission(this, permissao)
                    != PackageManager.PERMISSION_GRANTED) {
                permissoesRequeridas.add(permissao);
            }
        }

        if (!permissoesRequeridas.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    permissoesRequeridas.toArray(new
                            String[permissoesRequeridas.size()]),
                    CODIGO_PERMISSOES_REQUERIDAS);
            return false;
        }
        // alert(Todas as permissões estam ativas);
        return true;

    }public void abrircontatos(View v){

        Intent myIntent = new Intent(getApplicationContext(), contatos.class);
        startActivity(myIntent);

    }public void abrirmeta(View v){


      Intent myIntent = new Intent(getApplicationContext(), Meta.class);

        startActivity(myIntent);

    }  public void abrirmusic(View v){
        String URL = "https://www.deezer.com/playlist/8690135382";
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setData(Uri.parse(URL));
        startActivity(myIntent);

    }
    public void abrirAjuda(View v){

        Intent myIntent = new Intent(getApplicationContext(), ajuda.class);
        startActivity(myIntent);

    } public void abrirAjud(View v){



                LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);

// Verifica se o GPS está ativo
                boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);

// Caso não esteja ativo abre um novo diálogo com as configurações para
// realizar se ativamento
                if (!enabled) {

                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    Intent callGPSSettingIntent = new Intent(
                                            android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                    startActivity(callGPSSettingIntent);
                                    break;
                            }
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    AlertDialog mNoGpsDialog = builder.setMessage("Por favor ative seu GPS para correr")
                            .setPositiveButton("Ativar", dialogClickListener)
                            .create();
                    mNoGpsDialog.show();
                }else{     Intent myIntent = new Intent(getApplicationContext(), location.class);
                    startActivity(myIntent);  }


    }
}