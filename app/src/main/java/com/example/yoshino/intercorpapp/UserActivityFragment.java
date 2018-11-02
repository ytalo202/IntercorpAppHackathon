package com.example.yoshino.intercorpapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class UserActivityFragment extends Fragment {



    static final String PREFERENCIAS_COMPARTIDAD= "preferenciaCompartida";

    static final String SH_NOMBRE ="shNombre";

    static final String SH_APELLIDO ="shApellido";
    static final String SH_EDAD ="shEdad";

    static final String SH_FECH_IN ="shFechaIn";

    static final String SH_GENE ="shGene";

    SharedPreferences configuracion;

    String nombre,apellido,edad,fechaIn,gene;

    View v;



    public UserActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.user_fragment,container,false);

        Button ver = v.findViewById(R.id.btnVerAvance);
        EditText nom = v.findViewById(R.id.erlNombre);

        EditText ape = v.findViewById(R.id.erlApe);

        EditText eda = v.findViewById(R.id.erlEdad);
        EditText fech = v.findViewById(R.id.erlFechaIN);
        EditText gen = v.findViewById(R.id.erlGenero);

        nom.setText(nombre);
        ape.setText(apellido);
        eda.setText(edad);
        fech.setText(fechaIn);
        gen.setText(gene);


        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(getContext(),ProgresssActivity.class);
                startActivity(p);
            }
        });
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        SharedPreferences configuracion;


        configuracion = getContext().getSharedPreferences(PREFERENCIAS_COMPARTIDAD, 0);
        nombre = configuracion.getString(SH_NOMBRE, "0");
        apellido = configuracion.getString(SH_APELLIDO, "0");
        edad = configuracion.getString(SH_EDAD, "0");
        fechaIn = configuracion.getString(SH_FECH_IN, "0");
        gene = configuracion.getString(SH_GENE, "0");

    }
}
