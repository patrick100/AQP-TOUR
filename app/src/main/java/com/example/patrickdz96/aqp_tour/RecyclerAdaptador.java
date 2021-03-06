package com.example.patrickdz96.aqp_tour;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by patrickdz96 on 12/21/2017.
 */

public class RecyclerAdaptador  extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder>{

    List<Item> paisaje;

    RecyclerAdaptador(List<Item> paisaje){
        this.paisaje = paisaje;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        CardView cv;
        TextView nameAuthor;
        ImageView photo;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card);
            nameAuthor = (TextView)itemView.findViewById(R.id.descripcion);
            photo = (ImageView)itemView.findViewById(R.id.imagen);

            cv.setOnClickListener(this);
        }

        public void onClick(View v) {

            //v.getId();

            //Toast.makeText(v.getContext(),"BUSCANDO RUTA", Toast.LENGTH_LONG).show();

            Intent myIntent = new Intent(v.getContext(), MainActivity.class);
            //myIntent.putExtra("bus","mybus"); //Optional parameters
            v.getContext().startActivity(myIntent);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameAuthor.setText(paisaje.get(position).descripcion);
        holder.photo.setImageResource(paisaje.get(position).photoId);
    }

    @Override
    public int getItemCount() {
        return paisaje.size();
    }
}
