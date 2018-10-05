package com.example.android.tallermaterialclase;

public class Carro {
    private int foto;
    private String placa;
    private String color;
    private String marca;
    private int precio;

    public Carro(int foto, String placa, String color, String marca, int precio) {
        this.foto = foto;
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.precio = precio;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
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
