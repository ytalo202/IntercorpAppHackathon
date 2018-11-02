package com.example.yoshino.intercorpapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InformeActivity extends AppCompatActivity {


    static final String PREFERENCIAS_COMPARTIDAD= "preferenciaCompartida";

    static final String SH_NProyecto ="shNproyecto";

    static final String SH_TProyecto="shTproyecto";
    static final String SH_PProyecto="shPproyecto";

    SharedPreferences configuracion;

    String nombre,puntos,tema;

    private RecyclerView myrecyclerView;
    private List<Contact3> lstContact;

    TextView nom,pun,tipo;
    RecyclerViewMensajeAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);
nom = findViewById(R.id.name_contact);
        tipo = findViewById(R.id.phone_contac);
        pun = findViewById(R.id.txtNumPuntos);

        configuracion = getSharedPreferences(PREFERENCIAS_COMPARTIDAD, 0);
        nombre = configuracion.getString(SH_NProyecto, "0");
        puntos = configuracion.getString(SH_PProyecto, "0");
        tema = configuracion.getString(SH_TProyecto, "0");

        nom.setText(nombre);
        tipo.setText(tema);
        pun.setText(puntos);

        myrecyclerView = findViewById(R.id.list_search);

        lstContact = new ArrayList<>();

        lstContact.add(new Contact3("Ytalo","Master Oro",R.drawable.f1));
        lstContact.add(new Contact3("Pedro","Experto",R.drawable.f2));
        lstContact.add(new Contact3("Loreso","Novato",R.drawable.f5));
        lstContact.add(new Contact3("Pablo","Experto Platino",R.drawable.f6));
        lstContact.add(new Contact3("Juancho","Master Platino",R.drawable.f9));
        lstContact.add(new Contact3("Franco","Novato",R.drawable.f8));

        recyclerViewAdapter = new RecyclerViewMensajeAdapter(this,lstContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myrecyclerView.setAdapter(recyclerViewAdapter);
    }
}
