package com.example.appbdlibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bibliotecaSBD crearBd= new bibliotecaSBD(this);

        //SQLiteDatabase bd = crearBd.getWritableDatabase();

        //bd.execSQL("INSERT INTO libros VALUES(1,'el quijote');");
        //bd.close();
    }

    public void ConsultarLibro(View v)
    {
        EditText edcodigo=(EditText) findViewById(R.id.edCodigo);
        EditText edtitulo=(EditText) findViewById(R.id.edTitulo);
        EditText edautor=(EditText) findViewById(R.id.edAutor);
        String cod=edcodigo.getText().toString();
        bibliotecaSBD crearBd= new bibliotecaSBD(this);
        SQLiteDatabase bd = crearBd.getReadableDatabase();
        Cursor contenido = bd.rawQuery("select * from libros where codigo='" + cod + "';", null);
        if (contenido.moveToNext()){
            edtitulo.setText(contenido.getString(1));
            edautor.setText(contenido.getString(2));  }
        contenido.close();
        bd.close();
    }


    public void insertarLibro(View v) {
        bibliotecaSBD crearBd= new bibliotecaSBD(this);
        SQLiteDatabase bd = crearBd.getWritableDatabase();
        EditText edcodigo=(EditText) findViewById(R.id.edCodigo);
        EditText edtitulo=(EditText) findViewById(R.id.edTitulo);
        EditText edautor=(EditText) findViewById(R.id.edAutor);
        if (edcodigo.getText().toString().equals("") || edtitulo.getText().toString().equals("") || edautor.getText().toString().equals(""))
            verMensajeToast("Cajas vacías, debes introducir los datos");
        else {
            String cod=edcodigo.getText().toString();
            String tit=edtitulo.getText().toString();
            String aut=edautor.getText().toString();
            try
            {
                bd.execSQL ("INSERT INTO LIBROS VALUES ("+cod + ",'" + tit + "','" + aut +"'); ");
                verMensajeToast("Datos Insertados");
            }catch (Exception sqlex){
                verMensajeToast(sqlex.getMessage());}
        }
        limpiarCajas();
        bd.close();
    }

    public void verMensajeToast(String mensaje){
        Toast toast=Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
        toast.show();
    }

    public void limpiarCajas(){
        EditText edcodigo=(EditText) findViewById(R.id.edCodigo);
        EditText edtitulo=(EditText) findViewById(R.id.edTitulo);
        EditText edautor=(EditText) findViewById(R.id.edAutor);
        edcodigo.setText(null);
        edtitulo.setText(null);
        edautor.setText(null);
    }

    public void borrarLibro(View v) {
        EditText edcodigo=(EditText) findViewById(R.id.edCodigo);
        bibliotecaSBD crearBd= new bibliotecaSBD(this);
        SQLiteDatabase bd = crearBd.getWritableDatabase();
        if (edcodigo.getText().toString().equals(""))
            verMensajeToast("Introduce un código");
        else {
            String cod=edcodigo.getText().toString();
            try
            {
                bd.execSQL ("delete from libros where codigo="+cod+";");
                verMensajeToast("Datos Borrados");
            }catch (Exception sqlex){
                verMensajeToast(sqlex.getMessage());}
        }
        limpiarCajas();
        bd.close();
    }

    public void listarContenido(View v){
        Intent i = new Intent (this, VerLibros.class);
        startActivity(i);
    }

}