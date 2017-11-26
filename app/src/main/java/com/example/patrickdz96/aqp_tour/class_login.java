package com.example.patrickdz96.aqp_tour;

//https://developer.android.com/reference/android/database/Cursor.html#getCount()
//https://developer.android.com/training/maps/index.html?
//https://sqliteonline.com/
//https://www.youtube.com/watch?v=BG6VsnvOvl8&index=84&list=PLU8oAlHdN5Bkn-KS1sRFlSEnXXcAtAJ9P

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

public class class_login extends Activity {
    EditText username,pasword;
    Button btnbuscar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //con esta linea lo vinculas la clase con el layout
        setContentView(R.layout.layout_login);
        Button btnregistrar;
        btnbuscar=(Button)findViewById(R.id.login);

        username=(EditText)findViewById(R.id.username);
        pasword=(EditText)findViewById(R.id.contraseña);
        final BasedeDatosHelper  BDHelper = new BasedeDatosHelper(this);
        final Intent j = new Intent(this,Login.class);
        btnbuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //ler la base en la base de datos
                SQLiteDatabase db = BDHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
                String[] projection = {
                        Estructura_BasedeDatos.NAME_COLUMN1,
                        Estructura_BasedeDatos.NAME_COLUMN2,
                };

// Filter results WHERE "title" = 'My Title'
                String selection = Estructura_BasedeDatos.NAME_COLUMN3 + " = ?";
                String[] selectionArgs = { username.getText().toString() };

// How you want the results(Array) sorted in the resulting Cursor
                /*String sortOrder =
                        FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";*/

                Cursor cursor = db.query(
                        Estructura_BasedeDatos.TABLE_NAME,                     // The table to query
                        projection,                               // The columns to return
                        selection,                                // The columns for the WHERE clause
                        selectionArgs,                            // The values for the WHERE clause
                        null,                                     // don't group the rows
                        null,                                     // don't filter by row groups
                        null                                 // The sort order
                );
                if(cursor.getCount()==1)
                {
                    startActivity(j);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Esta incorecto username" ,
                            Toast.LENGTH_LONG).show();
                    username.setText("");
                    pasword.setText("");
                }

            }
        });

    }

    public void regresar(View view)
    {
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
}
