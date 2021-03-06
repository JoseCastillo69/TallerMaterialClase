package com.example.android.tallermaterialclase;

public class Carro {
    private String id;
    private int foto;
    private String placa;
    private int color;
    private int marca;
    private int precio;

    public Carro(String id, int foto, String placa, int color, int marca, int precio) {
        this.id = id;
        this.foto = foto;
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void NuevaC(){
        datos.agregar(this);
    }
}
