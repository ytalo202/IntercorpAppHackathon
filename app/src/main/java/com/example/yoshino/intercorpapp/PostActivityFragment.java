package com.example.yoshino.intercorpapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PostActivityFragment extends Fragment {


    View v;

    private RecyclerView myrecyclerView;
    private List<Contact> lstContact;
    RecyclerViewAdapter recyclerViewAdapter;

    public PostActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.post_fragment, container, false);


        myrecyclerView = v.findViewById(R.id.list_search);

        lstContact = new ArrayList<>();
String fl ="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, " +
        "   ";



        lstContact.add(new Contact("Investigación Presupuestal","Estudio",R.drawable.f1,"18",fl));
        lstContact.add(new Contact("Implementación de Grupo Electrogeno","Proyecto",R.drawable.f2,"120",fl));
        lstContact.add(new Contact("Sistema Comercial","Proyecto",R.drawable.f3,"11",fl));
        lstContact.add(new Contact("Automatización de Adquisiciones","Proyecto",R.drawable.f4,"8",fl));
        lstContact.add(new Contact("Transición a la ciencia de datos","Articulo",R.drawable.f5,"5",fl));
        lstContact.add(new Contact("Ayuda sobre java","Foro",R.drawable.f6,"8",fl));


//        lstContact.add(new Contact("Ytalo","999123456",R.drawable.cpu,R.drawable.d3));
//        lstContact.add(new Contact("Pedro","999123456",R.drawable.cpu,R.drawable.d4));
//        lstContact.add(new Contact("Loreso","999123456",R.drawable.cpu,R.drawable.d3));
//        lstContact.add(new Contact("Pablo","999123456",R.drawable.cpu,R.drawable.d4));
//        lstContact.add(new Contact("Juancho","999123456",R.drawable.cpu,R.drawable.d3));
//        lstContact.add(new Contact("Franco","999123456",R.drawable.cpu,R.drawable.d4));

        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(),lstContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapter);
        return v;

    }


}