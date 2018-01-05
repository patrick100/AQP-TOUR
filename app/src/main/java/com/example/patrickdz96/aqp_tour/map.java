package com.example.patrickdz96.aqp_tour;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;




public class map extends Fragment{

    private SupportMapFragment mapFragment;
    public GoogleMap mMap;

    ArrayList<LatLng> locations;

    public Marker usuario;

    public String url="";

    boolean iniciar = true;
    boolean emu = true;

    public Polyline line;

    /*

    public Marker marcador;
    public Marker mybus;
    double lat = 0.0;
    double lng = 0.0;
    int tipo = -1;
    int t = 0;
    boolean update_bus = false;
    ArrayList<LatLng> locations;
    */



    public void graficar_ruta(String url){



        //if(emulador==true){
        //    url = "https://maps.googleapis.com/maps/api/directions/json?origin=-16.400918327565073,-71.53597219126283&destination=-16.3988084,-71.53690560000001";
        //}
        //else{
            //line.remove();
                   //}


        //Toast.makeText(getContext(),url, Toast.LENGTH_SHORT).show();

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getContext());



    // Request a string response from the provided URL.


        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject  response) {
                    // Display the first 500 characters of the response string.
                    //Toast.makeText(getContext(),response.toString(), Toast.LENGTH_SHORT).show();


                    //JSONObject jsonData = null;
                    JSONArray steps = null;
                    JSONObject mystep = null;
                    JSONObject pos = null;
                    double lat = 0;
                    double lng = 0;
                    locations = new ArrayList();

                    //jsonData = new JSONObject(jsonStr);

                    //Obtiene el JSONArray de steps.
                    try {
                        steps = response.getJSONArray("routes").getJSONObject(0).getJSONArray("legs")
                                .getJSONObject(0).getJSONArray("steps");

                        for (int i = 0; i < steps.length(); i++) {


                            mystep = steps.getJSONObject(i);
                            pos = mystep.getJSONObject("start_location");

                            lat =  Double.parseDouble(pos.getString("lat"));
                            lng = Double.parseDouble(pos.getString("lng"));

                            //Toast.makeText(getContext(),pos.getString("lat") + pos.getString("lng") , Toast.LENGTH_SHORT).show();

                            locations.add(new LatLng(lat,lng));

                        }

                         line = mMap.addPolyline(
                                new PolylineOptions().addAll(locations).width(5).color(Color.BLUE).geodesic(true)
                        );

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getContext(),error.toString(), Toast.LENGTH_SHORT).show();
        }
    });


        queue.add(jsObjRequest);



        //HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        //String jsonStr = sh.makeServiceCall(url);
        //Toast.makeText(getContext(),jsonStr, Toast.LENGTH_LONG).show();

        //Log.d("RESPUESTA",jsonStr);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*
        locations = new ArrayList();
        locations.add(new LatLng(-16.4053857, -71.52866210000002));
        locations.add(new LatLng(-16.404614503616354, -71.52785186983647));
        locations.add(new LatLng(-16.404202820046404, -71.52733688570561));
        locations.add(new LatLng(-16.40362646158549, -71.52652149416508));
        locations.add(new LatLng(-16.403008932769055,-71.52583484865727));
        locations.add(new LatLng(-16.40239140199337, -71.52510528780522));
        locations.add(new LatLng(-16.401650362476428,-71.52420406557621));
        */


        /*
        locations = new ArrayList();

        locations.add(new LatLng(-16.400923473701912,-71.53594536917268));

        locations.add(new LatLng(-16.400542659208536,-71.53698606627046));
        locations.add(new LatLng(-16.39945681919786,-71.53654081957399));
        locations.add(new LatLng(-16.39925611824835,-71.53708799021302));

        locations.add(new LatLng(-16.3988084,-71.53690560000001));

        */

        return inflater.inflate(R.layout.map_fragment, container, false);
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();

        //if (bundle != null) {
        //    tipo = bundle.getInt("TIPO");
            //int value2 = bundle.getInt("VALUE2", -1);
        //}


        FragmentManager fm = getChildFragmentManager();

        mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, mapFragment).commit();
        } else {
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(final GoogleMap googleMap) {
                    mMap = googleMap;
                    if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED &&
                            ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                                    PackageManager.PERMISSION_GRANTED) {
                        googleMap.setMyLocationEnabled(true);


                        LocationManager locationM = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
                        if (locationM.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                            //Location location = locationM.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            //locationM.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,0,loclistener);

                        }else{
                            Toast.makeText(getContext(), "EL GPS NO ESTA ACTIVADO", Toast.LENGTH_LONG).show();
                        }




                    }else{
                        Toast.makeText(getContext(), "NO TIENE PERMISOS DE LOCALIZACION", Toast.LENGTH_LONG).show();
                    }

                    googleMap.getUiSettings().setZoomControlsEnabled(true);



                    usuario = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(-16.405277056720024,-71.52461571829377))
                            .title("Mi Posicion Actual")
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.player)));

                    //mMap.animateCamera(miUbicacion);

                    //PARA EL EMULADOR

                    //if(iniciar==true){
                    //    graficar_ruta(new LatLng(-16.40759789864996,-71.53855784075319),true);
                    //    iniciar = false;
                    //}


                    if(emu){

                        url = "https://maps.googleapis.com/maps/api/directions/json?origin=-16.405277056720024,-71.52461571829377&destination=-16.3988084,-71.53690560000001";
                        graficar_ruta(url);
                    }
                    else{

                        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {


                            @Override
                            public void onMyLocationChange(Location arg0) {
                                // TODO Auto-generated method stub
                                usuario.setPosition(new LatLng(arg0.getLatitude(), arg0.getLongitude()));
                                //Toast.makeText(getContext(),arg0.getLatitude()+" "+arg0.getLongitude(), Toast.LENGTH_SHORT).show();

                                if(iniciar==true){
                                    url = "https://maps.googleapis.com/maps/api/directions/json?origin="+arg0.getLatitude()+ "," +arg0.getLongitude() +" &destination=-16.3988084,-71.53690560000001";
                                    graficar_ruta(url);
                                    iniciar = false;
                                }

                            }
                        });

                    }



                    //LatLng lat1 = new LatLng(-16.400923473701912,-71.53594536917268);





                    //googleMap.addMarker(new MarkerOptions()
                    //        .position(lat1)
                    //        .title("Mi Ubicacion")
                    //        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.player)));

                    LatLng lat2 = new LatLng(-16.3988084,-71.53690560000001);
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    googleMap.addMarker(new MarkerOptions()
                            .position(lat2)
                            .title("PLAZA DE ARMAS DE AREQUIPA")
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.lugar)));






                    googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                    {

                        @Override
                        public boolean onMarkerClick(Marker arg0) {
                            if(arg0.getTitle().equals("PLAZA DE ARMAS DE AREQUIPA")) { // if marker source is clicked
                                Toast.makeText(getContext(), "MOSTRANDO INFORMACION", Toast.LENGTH_SHORT).show();
                                Intent myIntent = new Intent(getContext(), LugarTuristico.class);
                                //myIntent.putExtra("name",texto.getText().toString()); //Optional parameters
                                getContext().startActivity(myIntent);
                            }



                                //Toast.makeText(MainActivity.this, arg0.getTitle(), Toast.LENGTH_SHORT).show();// display toast
                            return true;
                        }

                    });


                }


            });
        }
    }





}
