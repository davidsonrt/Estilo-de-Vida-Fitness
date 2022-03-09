package com.example.style_de_vida_fitness;
 //o mesmo pacote das outras classes de seu App

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String TABELA = "Corridas"; //nome da tabela
    private static final String DATABASE_NAME = "db_Corridas"; //nome do BD
    private static final String TABLE_CREATE = "create table " + TABELA + " (a float, b float, c float, d float, e text);";
    SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
    public long Criarcorr(float a, float b, float c, float d, String e){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("a", a);
        cv.put("b", b);
        cv.put("c", c);
        cv.put("d", d);
        cv.put("e", e);
        long result = db.insert("Corridas",null, cv);
        return result;
    }

    public String hiskm(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where a = (select max(a) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(0);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }
    public String hiscrono(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where a = (select max(a) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(1);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }
    public String hismedia(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where a = (select max(a) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(2);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }
    public String hismax(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where a = (select max(a) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(3);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }
    public String hisdia(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where a = (select max(a) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(4);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }


    public String hiskm2(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where c = (select max(c) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(0);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }
    public String hiscrono2(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where c = (select max(c) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(1);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }
    public String hismedia2(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where c = (select max(c) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(2);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }
    public String hismax2(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where c = (select max(c) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(3);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }
    public String hisdia2(String username) {
        // instancia do objeto Usuario

        // Cariação do SQLiteDatabase a leitura do banco de dados
        SQLiteDatabase db = getReadableDatabase();
        // criação do cursor no qual recebera a query d do usuario
        Cursor cursor = db.rawQuery("select * from Corridas\n" +
                "where c = (select max(c) from Corridas)", null);
        // verifica se o cursos retornou alguma resultado
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                String usemeta = cursor.getString(4);
                return usemeta;
            } else {
                // caso não retornar nenhum usuario do cursor, o retorno da função será nula
                return "nao foi";
            }
        }
        db.close();
        return " ";
    }
}