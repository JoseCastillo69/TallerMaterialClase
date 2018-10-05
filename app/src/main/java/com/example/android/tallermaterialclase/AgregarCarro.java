package com.example.android.tallermaterialclase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCarro extends Activity {

    private EditText txtPlaca, txtPrecio;
    private Spinner cmbColor, cmbMarca;
    private String opc1[], opc2 [];
    private ArrayList<Integer> fotos;
    private ArrayList<Carro> listaCarros;
    private ImageView foto;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro);

        txtPlaca = findViewById(R.id.txtPlaca);
        txtPrecio = findViewById(R.id.txtPrecio);
        cmbColor = findViewById(R.id.cmbColor);
        cmbMarca= findViewById(R.id.cmbMarca);
        listaCarros = datos.obtener();

        opc1 = getResources().getStringArray(R.array.s_color);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc1);
        cmbColor.setAdapter(adapter);

        opc2 = getResources().getStringArray(R.array.s_marca);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc2);
        cmbMarca.setAdapter(adapter);

        //foto = findViewById(R.id.foto);
        fotos = new ArrayList<>();
        fotos.add(R.drawable.carro1);
        fotos.add(R.drawable.carro2);
        fotos.add(R.drawable.carro3);

    }

    public int fotoAleatoria(){
        int fotoSelecionada;
        Random r = new Random();
        fotoSelecionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSelecionada);
    }

    public void guardar(View v){
        String placa ="";
        int foto, color, marca, precio;
        foto = this.fotoAleatoria();

        if (validar()){
            placa = txtPlaca.getText().toString();


                for (int i = 0; i < listaCarros.size(); i++) {
                    if (listaCarros.get(i).getPlaca().equalsIgnoreCase(placa)) {
                        Toast.makeText(this, getResources().getString(R.string.error_placaI), Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            precio = Integer.parseInt(txtPrecio.getText().toString());
            color = cmbColor.getSelectedItemPosition();
            marca= cmbMarca.getSelectedItemPosition();

            Carro c = new Carro(foto, placa, color, marca, precio);
            c.NuevaC();

            Snackbar.make(v, getResources().getString(R.string.guardadoE), Snackbar.LENGTH_SHORT).show();

            borrar();

        }
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCarro.this,principal.class);
        startActivity(i);
    }

    public void limpiar(View v){
        borrar();
    }

    public void borrar(){
        txtPlaca.setText("");
        txtPrecio.setText("");
        cmbColor.setSelection(0);
        cmbMarca.setSelection(0);
        txtPlaca.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public boolean validar() {
        int o1 = cmbColor.getSelectedItemPosition();
        int o2 = cmbMarca.getSelectedItemPosition();

        if (txtPlaca.getText().toString().isEmpty()) {
            txtPlaca.setError(getResources().getString(R.string.error_placa));
            txtPlaca.requestFocus();
            return false;
        }

        if (o1 == 0) {
            Toast.makeText(this, getResources().getString(R.string.error_color), Toast.LENGTH_SHORT).show();
            cmbColor.requestFocus();
            return false;
        }

        if (o2 == 0) {
            Toast.makeText(this, getResources().getString(R.string.error_marca), Toast.LENGTH_SHORT).show();
            cmbColor.requestFocus();
            return false;
        }

        if (txtPrecio.getText().toString().isEmpty()) {
            txtPrecio.setError(getResources().getString(R.string.error_precio));
            txtPrecio.requestFocus();
            return false;
        }
        return true;
    }

}
