package com.example.patrickdz96.aqp_tour;


import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;

public class Login extends AppCompatActivity {
    // private Button btnlogin ;
    EditText nombre,apellido,username,pasword;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // btnlogin  = (Button) findViewById(R.id.login);
        // btnlogin.setOnClickListener(new View.OnClickListener() {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void ejecutaregistrar(View view)
    {
    Intent i = new Intent(this,class_registrar.class);
        startActivity(i);
    }

    public void buscar(View view)
    {
        Intent i = new Intent(this,class_login.class);
        startActivity(i);
        //final BasedeDatosHelper  BDHelper = new BasedeDatosHelper(this);
        //SQLiteDatabase db = BDHelper.g;

    }

    public void iniciar2(View v){
        Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    public void open4 (View view)
    {
        //open3(view.savedInstabceState);
    }

    ///pruebamia 3
    ///no poner con el bundle pues
    public void open3(View view )
    {
        LayoutInflater inflater = getLayoutInflater();
        AlertDialog.Builder alertaSimple = new AlertDialog.Builder(this);
        alertaSimple.setView(inflater.inflate(R.layout.layout_login, null))
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Registrar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //LoginDialogFragment.this.getDialog().cancel();
                        //finish();///finaliza el programa
                    }
                });
        alertaSimple.create();
        alertaSimple.show();

    }

    public void open2(View view )
    {
        nombre=(EditText)findViewById(R.id.nombres);
        apellido=(EditText)findViewById(R.id.apellidos);
        username=(EditText)findViewById(R.id.username);
        pasword=(EditText)findViewById(R.id.contraseña);

        final BasedeDatosHelper  BDHelper = new BasedeDatosHelper(this);
        LayoutInflater inflater = getLayoutInflater();
        AlertDialog.Builder alertaSimple = new AlertDialog.Builder(this);

        alertaSimple.setView(inflater.inflate(R.layout.layout_registrar, null))
                .setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                        // Gets the data repository in write mode
                        SQLiteDatabase db = BDHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        /*values.put(Estructura_BasedeDatos.NAME_COLUMN1,nombre.getText().toString() );
                        values.put(Estructura_BasedeDatos.NAME_COLUMN2,apellido.getText().toString());
                        values.put(Estructura_BasedeDatos.NAME_COLUMN3,username.getText().toString());
                        values.put(Estructura_BasedeDatos.NAME_COLUMN4,pasword.getText().toString());
                        values.put(Estructura_BasedeDatos.id,4);*/

// Insert the new row, returning the primary key value of the new row
                        String nombre2=nombre.getText().toString();
                        long newRowId = db.insert(Estructura_BasedeDatos.TABLE_NAME, null, values);
                        Toast.makeText(getApplicationContext(),"Seguardo registro:"+nombre2 ,
                                Toast.LENGTH_LONG).show();
// Create a new map of values, where column names are the keys

                        /*Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);*/
                    }
                })
                .setNegativeButton("Rechazar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //LoginDialogFragment.this.getDialog().cancel();
                        //finish();///finaliza el programa

                    }
                });
        alertaSimple.create();
        alertaSimple.show();
    }
    /*
    public void go(View view) {
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }*/


    public void iniciar(View v){
        Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();

        //Intent myIntent = new Intent(Login.this, MainActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        //Login.this.startActivity(myIntent);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }
    ///bundle es para pasar los datos de actividades


}

