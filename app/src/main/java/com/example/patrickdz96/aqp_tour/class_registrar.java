package com.example.patrickdz96.aqp_tour;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;


/**
 * Created by TErikaT on 19/11/2017.
 * ver la base de datos acas https://sqliteonline.com/
 */

public class class_registrar extends Activity {
    EditText nombre,apellido,username,pasword;
    Button btnregistrar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //con esta linea lo vinculas la clase con el layout
        setContentView(R.layout.layout_registrar);
        Button btnregistrar;
        btnregistrar=(Button)findViewById(R.id.registrar);
        nombre=(EditText)findViewById(R.id.nombres);
        apellido=(EditText)findViewById(R.id.apellidos);
        username=(EditText)findViewById(R.id.username);
        pasword=(EditText)findViewById(R.id.contraseña);
        final BasedeDatosHelper  BDHelper = new BasedeDatosHelper(this);
        final Intent j = new Intent(this,Login.class);
        btnregistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = BDHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                        values.put(Estructura_BasedeDatos.NAME_COLUMN1,nombre.getText().toString() );
                        values.put(Estructura_BasedeDatos.NAME_COLUMN2,apellido.getText().toString());
                        values.put(Estructura_BasedeDatos.NAME_COLUMN3,username.getText().toString());
                        values.put(Estructura_BasedeDatos.NAME_COLUMN4,pasword.getText().toString());


// Insert the new row, returning the primary key value of the new row
                String nombre2=nombre.getText().toString();
                nombre.setText("");
                username.setText("");
                apellido.setText("");
                pasword.setText("");
                long newRowId = db.insert(Estructura_BasedeDatos.TABLE_NAME, null, values);
                Toast.makeText(getApplicationContext(),"Se creo un nuevo usuario" ,
                        Toast.LENGTH_LONG).show();
                startActivity(j);
            }
        });

    }

    public void regresar(View view)
    {
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
}
