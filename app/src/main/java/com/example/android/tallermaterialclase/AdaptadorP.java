package com.example.android.tallermaterialclase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorP extends RecyclerView.Adapter<AdaptadorP.PersonaViewHolder> {

    private ArrayList<Carro> carros;

    public AdaptadorP(ArrayList<Carro> personas){
        this.carros = personas;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carro,parent,false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        Carro p = carros.get(position);
        holder.foto.setImageResource(p.getFoto());
        holder.placa.setText(p.getPlaca());
        holder.marca.setText(p.getMarca());
        holder.precio.setText(p.getPrecio());

    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView placa;
        private TextView marca;
        private TextView precio;
        private View v;

        public PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            placa = v.findViewById(R.id.lblPlaca);
            marca = v.findViewById(R.id.lblMarca);
            precio = v.findViewById(R.id.lblPrecio);


        }

    }

}
