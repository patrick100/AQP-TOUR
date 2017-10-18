package com.example.patrickdz96.aqp_tour;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class map extends Fragment{

    private SupportMapFragment mapFragment;

    /*
    public GoogleMap mMap;
    public Marker marcador;
    public Marker mybus;
    double lat = 0.0;
    double lng = 0.0;
    int tipo = -1;
    int t = 0;
    boolean update_bus = false;
    ArrayList<LatLng> locations;
    */




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
                    //mMap = googleMap;
                    if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED &&
                            ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                                    PackageManager.PERMISSION_GRANTED) {
                        googleMap.setMyLocationEnabled(true);

                    }
                    googleMap.getUiSettings().setZoomControlsEnabled(true);

                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(-16.399387345815672,-71.53664810793458))
                            .title("My Location")
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.player)));


                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(-16.3988084,-71.53690560000001))
                            .title("PLAZA DE ARMAS DE AREQUIPA")
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.lugar)));

                    googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                    {

                        @Override
                        public boolean onMarkerClick(Marker arg0) {
                            if(arg0.getTitle().equals("PLAZA DE ARMAS DE AREQUIPA")) // if marker source is clicked
                                Toast.makeText(getContext(), "MOSTRANDO INFORMACION", Toast.LENGTH_SHORT).show();
                                Intent myIntent = new Intent(getContext(), LugarTuristico.class);
                                //myIntent.putExtra("name",texto.getText().toString()); //Optional parameters
                                 getContext().startActivity(myIntent);


                                //Toast.makeText(MainActivity.this, arg0.getTitle(), Toast.LENGTH_SHORT).show();// display toast
                            return true;
                        }

                    });


                }


            });
        }
    }





}
