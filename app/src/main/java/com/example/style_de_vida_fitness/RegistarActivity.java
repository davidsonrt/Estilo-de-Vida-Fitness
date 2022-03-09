package com.example.style_de_vida_fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistarActivity extends AppCompatActivity {
    EditText et_username;
    CardView bt_registrar;
    RadioButton fem,mas;
    DBHelper db;



    public static SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("");
        db = new DBHelper(this);

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registar);


            et_username = (EditText) findViewById(R.id.idregisternome);
            fem = (RadioButton) findViewById(R.id.btfeminino);
            mas = (RadioButton) findViewById(R.id.btmasculino);
            bt_registrar = (CardView) findViewById(R.id.idregistrar2);




        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();



                String genero = "";

                if (username.equals("")) {
                    Toast.makeText(RegistarActivity.this, "Nome não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else if(!mas.isChecked() & !fem.isChecked()){
                    Toast.makeText(RegistarActivity.this,"Informe o seu sexo", Toast.LENGTH_SHORT).show();
                }else{
                    if (mas.isChecked()) {
                        genero = "m";
                    } else if (fem.isChecked()) {
                        genero = "f";
                    }

                   /* long res = db.CriarUtilizador(username, username, username, username, met, genero);
                    if (res > 0) {
                        Toast.makeText(RegistarActivity.this, "Bem vindo!", Toast.LENGTH_SHORT).show();

                    }*/
                    Intent myIntenti = new Intent(getApplicationContext(), Registro2.class);
                    myIntenti.putExtra("nome", username);
                    myIntenti.putExtra("sexo", genero);

                    startActivity(myIntenti);
                    RegistarActivity.this.finish();
                }
            }
        });


        }

   }
