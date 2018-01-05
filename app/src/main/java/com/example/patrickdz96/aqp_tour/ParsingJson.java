package com.example.patrickdz96.aqp_tour;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static android.content.ContentValues.TAG;


public class ParsingJson {



    protected void ejecutar() {
        ProgressDialog pDialog;
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=-16.400923473701912,-71.53594536917268&destination=-16.3988084,-71.53690560000001";
        HttpHandler sh = new HttpHandler();

        // Making a request to url and getting response
        String jsonStr = sh.makeServiceCall(url);

        Log.d("JSON", jsonStr);

        if (jsonStr != null) {

            //Log.d("ok", "Procesando el json.");

            /*
            JSONObject jsonData = null;
            JSONArray steps = null;

            jsonData = new JSONObject(jsonStr);

            //Obtiene el JSONArray de steps.
            steps = jsonData.getJSONArray("routes").getJSONObject(0).getJSONArray("legs")
                        .getJSONObject(0).getJSONArray("steps");

            for (int i = 0; i < steps.length(); i++) {
                JSONObject leg = steps.getJSONObject(i);
                JSONObject jsonStartLocation = steps.getJSONObject("start_location");
            }
            */

        }
    }

}