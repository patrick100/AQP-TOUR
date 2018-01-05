package com.example.patrickdz96.aqp_tour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by patrickdz96 on 12/21/2017.
 */

public class Lista_Lugares_Turisticos extends AppCompatActivity {

    private List<Item> Items;
    public RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);


        //--------------------------------------------------
        recycler = (RecyclerView)findViewById(R.id.mostrador);
        LinearLayoutManager lin = new LinearLayoutManager(this);
        lin.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(lin);
        recycler.setHasFixedSize(true);

        inicializarDatos();
        inicializarAdaptador();
        //-----------------------------------------------------------

    }


    public void inicializarDatos(){
        Items = new ArrayList<>();
        Items.add(new Item("PLAZA DE ARMAS DE AREQUIPA",R.drawable.lugar1));
        Items.add(new Item("MONASTERIO DE SANTA CATALINA",R.drawable.lugar2));
        Items.add(new Item("MOLINO DE SABANDIA",R.drawable.lugar3));
        //fotografias.add(new Fotografia("COTUM",R.drawable.cotum));
        //fotografias.add(new Fotografia("LOS BLANCOS",R.drawable.losblancos));

    }

    public void inicializarAdaptador(){
        RecyclerAdaptador adapter = new RecyclerAdaptador(Items);
        recycler.setAdapter(adapter);
    }

}

