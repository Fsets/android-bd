package com.example.appbdlibros;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class bibliotecaSBD extends SQLiteOpenHelper {
    //Nombre de la base de datos
    public static final String NOMBREBD = "bdbiblioteca.sdb";
    //Versión de la base de datos
    public static final int VERSION = 1;
    //Nombre de la tabla (puede haber tantas como necesitemos)
    //public static final String NOMBRE_TABLA = "libros";
    //Atributos o campos de la tabla
    //public static final String REF = "ref";
    //public static final String NOMBRE = "nombre";

    public bibliotecaSBD(Context context) {
        super(context, NOMBREBD, null, VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists libros (codigo varchar(10) primary key, titulo varchar(20), autor varchar(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
