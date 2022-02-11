/*package com.example.appbdlibros;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class verLibros2 extends AppCompatActivity {
    ListView lista1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verlibros);
        lista1 = (ListView) findViewById(R.id.lista1);
        bibliotecaSBD crearBd = new bibliotecaSBD(this);
        List<Libro> items = new ArrayList<Libro>();
        SQLiteDatabase bd = crearBd.getReadableDatabase();
        Cursor contenido = bd.rawQuery("select * from libros", null);
        int i = 0;
        String cad = "";
        while (contenido.moveToNext() && i < contenido.getCount()) {
            cad = " " + contenido.getString(0) + " " + contenido.getString(1) + " " + contenido.getString(2) + " \n";
            items.add(cad);
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lista1.setAdapter(adapter);
        contenido.close();
        bd.close();
    }

}
*/
