package com.example.android.tallermaterialclase;

import java.util.ArrayList;

public class datos {

    public static ArrayList<Carro> listac = new ArrayList();

    public static void agregar(Carro c){
        listac.add(c);
    }

    public static ArrayList<Carro> obtener (){
        return listac;
    }
}
