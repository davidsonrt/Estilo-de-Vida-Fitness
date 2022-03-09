package com.example.style_de_vida_fitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.provider.ContactsContract;

public class DBHelper extends SQLiteOpenHelper {
    private static int versao = 1;
    private static String nome="Login_Registro_BaseDados.db";

    public DBHelper(Context context
    ) {
        super(context, nome, null, versao);
    }
    // String str = "CREATE TABLE Utilizador(username TEXT PRIMARY KEY, password TEXT);";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE  Utilizador( username TEXT, meta TEXT, sexo CHAR)";
        db.execSQL(str);
    }/*  "CREATE TABLE " + Utilizador + " (" +
    username + " TEXT PRIMARY KEY," +
    sobrenome + " TEXT," +
    email + " TEXT," + password + " TEXT)";*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utilizador;");
        onCreate(db);

    }public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public long CriarUtilizador(String username, String meta, String sexo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("meta",meta);
        cv.put("sexo",sexo);
        long result = db.insert("Utilizador",null, cv);
        return result;
    }
    public String verificarUtilizador(String nulla){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        Cursor c = db.rawQuery("SELECT * FROM Utilizador", null);


        if(c.getCount()>0){
            return "OK";
        }
        return "ERRO";
    }

    public String buscameta(String username){
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("SELECT meta FROM Utilizador" , null);
        // verifica se o cursos retornou alguma resultado
        if(cursor!=null){
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(0);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        // finaliza o SQLiteDatabase
        db.close();
        return " ";
    }
    public String buscamnome(String username){
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("SELECT username FROM Utilizador" , null);
        // verifica se o cursos retornou alguma resultado
        if(cursor!=null){
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(0);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        // finaliza o SQLiteDatabase
        db.close();
        return " ";
    }





    public String buscaSEXO(String username){
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("SELECT sexo FROM Utilizador" , null);
        // verifica se o cursos retornou alguma resultado
        if(cursor!=null){
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(0);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        // finaliza o SQLiteDatabase
        db.close();
        return " ";
    }
    public long alterameta(String username, String meta){
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        ContentValues cv4 = new ContentValues();
        cv4.put("meta", meta);
        // criação do cursor no qual recebera a query d do usuario
        long result4 = db.update("Utilizador", cv4, "username = '" + username + "'" , null);
        return result4;
    }
}
