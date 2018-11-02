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

public class RankingActivityFragment extends Fragment {


    View v;



    private RecyclerView myrecyclerView;
    private List<Contact2> lstContact;
    RecyclerViewRankingAdapter recyclerViewAdapter;

    public RankingActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.ranking_fragment,container,false);


        myrecyclerView = v.findViewById(R.id.list_search);

        lstContact = new ArrayList<>();

        lstContact.add(new Contact2("Ytalo","Maestro Dorado",R.drawable.f1,1000,111,2));
        lstContact.add(new Contact2("Pedro","Maestro Platino",R.drawable.f2,100,80,52));
        lstContact.add(new Contact2("Lorensa","Maestro Platino",R.drawable.f3,89,71,22));
        lstContact.add(new Contact2("Berta","Maestro Bronce",R.drawable.f4,60,61,82));
        lstContact.add(new Contact2("Pancha","Experto Dorado",R.drawable.f5,50,91,32));
        lstContact.add(new Contact2("Franco","Experto Platino",R.drawable.f6,50,70,72));

        lstContact.add(new Contact2("Miguel","Experto Platino",R.drawable.f7,49,71,22));
        lstContact.add(new Contact2("Pancho","Experto Bronce",R.drawable.f8,40,61,82));
        lstContact.add(new Contact2("Giliberto","Experto Medio",R.drawable.f9,36,91,32));
        lstContact.add(new Contact2("Fabiola","Experto Medio",R.drawable.f10,33,70,72));


//        lstContact.add(new Contact("Ytalo","999123456",R.drawable.cpu,R.drawable.d3));
//        lstContact.add(new Contact("Pedro","999123456",R.drawable.cpu,R.drawable.d4));
//        lstContact.add(new Contact("Loreso","999123456",R.drawable.cpu,R.drawable.d3));
//        lstContact.add(new Contact("Pablo","999123456",R.drawable.cpu,R.drawable.d4));
//        lstContact.add(new Contact("Juancho","999123456",R.drawable.cpu,R.drawable.d3));
//        lstContact.add(new Contact("Franco","999123456",R.drawable.cpu,R.drawable.d4));

        recyclerViewAdapter = new RecyclerViewRankingAdapter(getActivity(),lstContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapter);
        return v;


    }



}
