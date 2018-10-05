package com.example.android.tallermaterialclase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class principal extends AppCompatActivity {

    Intent i;
    private RecyclerView lstP;
    private ArrayList<Carro> carros;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstP= findViewById(R.id.lstPersonas);
        carros = datos.obtener();

        AdaptadorP adaptP = new AdaptadorP(carros,this);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lstP.setLayoutManager(llm);
        lstP.setAdapter(adaptP);
    }

    public void agregarPersona(View v){
        i = new Intent(principal.this, AgregarCarro.class);
        startActivity(i);
        finish();
    }
}
