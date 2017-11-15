package com.example.patrickdz96.aqp_tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*
        Button button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });*/
    }


    public void go(View view) {
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }


    public void iniciar(View v){
        Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();

        //Intent myIntent = new Intent(Login.this, MainActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        //Login.this.startActivity(myIntent);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }
}
