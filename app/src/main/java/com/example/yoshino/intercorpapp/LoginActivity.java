package com.example.yoshino.intercorpapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class LoginActivity extends AppCompatActivity {


    static final String PREFERENCIAS_COMPARTIDAD= "preferenciaCompartida";

    static final String SH_NOMBRE ="shNombre";

    static final String SH_APELLIDO ="shApellido";
    static final String SH_EDAD ="shEdad";

    static final String SH_FECH_IN ="shFechaIn";

    static final String SH_GENE ="shGene";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Login(View view) {
        new TareaDialogo().execute();
    }

    public void newUser(View view) {

        Intent p = new Intent(this,RegisterActivity.class);
        startActivity(p);
    }


    private class TareaDialogo extends AsyncTask<String, Void, Void> {

        ProgressDialog progressDialog;


        @Override
        protected Void doInBackground(String... strings) {


            String URL = "https://plataformaretail3.azurewebsites.net/webservice/servicios.php?usuario=mac&password=123qaz456";
            RequestQueue queue = Volley.newRequestQueue(getApplication());


            StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {

                        JSONArray jsonArray = new JSONArray(response);



                        String estado = jsonArray.getJSONObject(0).getString("estado");


                        if (estado.equals("success")) {


                            String nombre = jsonArray.getJSONObject(0).getString("nombres");
                            String apellidos = jsonArray.getJSONObject(0).getString("apellidos");
                            String edad = jsonArray.getJSONObject(0).getString("edad");
                            String fecha_ingreso = jsonArray.getJSONObject(0).getString("fecha_ingreso");

                            String genero = jsonArray.getJSONObject(0).getString("genero");


                            Toast.makeText(LoginActivity.this, "BIENVENIDO :D " + nombre, Toast.LENGTH_SHORT).show();


                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);


                                SharedPreferences configuracion = getSharedPreferences(PREFERENCIAS_COMPARTIDAD,0);
                                //modificar el archivo utiliso un editor
                                SharedPreferences.Editor editor = configuracion.edit();




                                //ingreso la informacion
                                editor.putString(SH_NOMBRE,nombre);
                                editor.putString(SH_APELLIDO,apellidos);

                                editor.putString(SH_EDAD,edad);
                                editor.putString(SH_FECH_IN,fecha_ingreso);
                                editor.putString(SH_GENE,genero);

                                editor.commit();

                            startActivity(intent);


                        }

                        else {
                            Toast.makeText(LoginActivity.this, "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception ex) {
                        Toast.makeText(LoginActivity.this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginActivity.this, "Error en el codigo broh ", Toast.LENGTH_SHORT).show();
                }
            });
            queue.add(stringRequest);

            return null;
        }

        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(LoginActivity.this, "",
                    "Cargando...");
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            try {

                Thread.sleep(1 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
