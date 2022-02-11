package com.example.appbdlibros;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class VerLibros extends AppCompatActivity {
    ListView lista1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verlibros);

        lista1=(ListView) findViewById(R.id.lista1);
        bibliotecaSBD crearBd= new bibliotecaSBD(this);
        List<String> items = new ArrayList<String>();
        SQLiteDatabase bd = crearBd.getReadableDatabase();
        Cursor contenido = bd.rawQuery("select * from libros", null);
        int i=0;
        String cad="";
        while (contenido.moveToNext() && i<contenido.getCount())
        {
            cad=" "+contenido.getString(0)+" "+contenido.getString(1)+" " + contenido.getString(2) + " \n";
            items.add(cad);
            i++;
        }
        ArrayAdapter <String> adapter=new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1, items);
        lista1.setAdapter(adapter);
        contenido.close();
        bd.close();

    }
/*
    public void consultarLibros(View v)
    {
        bibliotecaSBD crearBd= new bibliotecaSBD(this);
        List <String> items = new ArrayList <String>();
        SQLiteDatabase bd = crearBd.getReadableDatabase();
        Cursor contenido = bd.rawQuery("select * from libros", null);
        int i=0;
        String cad="";
        //volcamos el contenido del cursor en el arrayList.
        while (contenido.moveToNext() && i<contenido.getCount())
        {
            //concatena los datos de cada libro en un String cad.
            cad=""+contenido.getString(0)+"  "+contenido.getString(1)+"  " + contenido.getString(2) + "\n";
            items.add(cad);
            i++;
        }
        //Define un ArrayAdapter y volcamos en él el contenido del Arraylist items
        ArrayAdapter <String> adapter=new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1, items);
        //llenamos el ListView listaLibros
        lista1.setAdapter(adapter);
        contenido.close();
        bd.close();
    }*/
}
