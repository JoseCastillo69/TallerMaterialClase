package com.example.android.tallermaterialclase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class datos {

    private static String db ="Personas";

    private static DatabaseReference databaseReferencie = FirebaseDatabase.getInstance().getReference();

    public static ArrayList<Carro> listac = new ArrayList();

    public static void agregar(Carro c){
        databaseReferencie.child(db).child(c.getId()).setValue(c);
    }

    public static String getId(){
        return databaseReferencie.push().getKey();
    }

    public static void setPersonas (ArrayList<Carro> personas){
        datos.listac = personas;
    }

    public static ArrayList<Carro> obtener (){
        return listac;
    }
}
